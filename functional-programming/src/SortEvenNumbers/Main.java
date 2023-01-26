package SortEvenNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> line = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt)
                        .collect(Collectors.toList());

        line.removeIf(num -> num % 2 != 0);
        String numbers = line.stream().map(Objects::toString).collect(Collectors.joining(", "));

        line.sort(Integer::compareTo);

        String sortedNumbers = line.stream().map(Objects::toString).collect(Collectors.joining(", "));

        System.out.println(numbers);
        System.out.println(sortedNumbers);


    }

}
