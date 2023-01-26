package SumNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(", ");


        Function<String, Integer> parse = Integer::parseInt;

        int sum = 0;
        for (String number : numbers) {
            sum += parse.apply(number);
        }

        System.out.println("Count = " + numbers.length);
        System.out.println("Sum = " + sum);
    }
}
