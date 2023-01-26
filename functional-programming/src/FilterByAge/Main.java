package FilterByAge;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> data = new LinkedHashMap<>();

        List<Person> people = IntStream.range(0, n)
                .mapToObj(i -> readPerson(scanner))
                .collect(Collectors.toList());

        String ageCondition = scanner.nextLine();
        int ageFilter = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        people = filterByAgeCondition(people, getPredicate(ageCondition, ageFilter));

        Consumer<Person> printer = getPrinter(format);

        people.forEach(printer);

    }

    public static Person readPerson(Scanner scanner) {
        String[] data = scanner.nextLine().split(", ");

        String name = data[0];
        int age = Integer.parseInt(data[1]);

        return new Person(name, age);
    }

    private static Consumer<Person> getPrinter(String outputFormat) {
        switch(outputFormat) {
            case "name":
                return p -> System.out.println(p.name);
            case "age":
                return p-> System.out.println(p.age);
            case "name age":
                return p-> System.out.println(p.name + " - " + p.age);
            default:
                throw new IllegalArgumentException("Unknown format " + outputFormat);
        }
    }

    public static Predicate<Person> getPredicate(String ageCondition, int ageFilter) {
        switch(ageCondition) {
            case "younger":
                return p-> p.age <= ageFilter;
            case "older":
                return p -> p.age >= ageFilter;
            default:
                throw new IllegalArgumentException("Invalid parameters for age predicate, " + ageCondition + " " + ageFilter);
        }
    }

    public static List<Person> filterByAgeCondition(List<Person> people, Predicate<Person> predicate) {
        return people.stream().
                filter(predicate)
                .collect(Collectors.toList());
    }
}
