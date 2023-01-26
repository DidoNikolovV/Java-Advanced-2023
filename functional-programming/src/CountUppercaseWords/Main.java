package CountUppercaseWords;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split("\\s");

        Predicate<String> startsWithUppercase = w -> Character.isUpperCase(w.charAt(0));
        Consumer<String> print = System.out::println;

        List<String> wordsStartingWithUppercase= Arrays.stream(line)
                .filter(startsWithUppercase).collect(Collectors.toList());

        System.out.println(wordsStartingWithUppercase.size());
        wordsStartingWithUppercase
                .forEach(print);
    }
}
