package FindEvensOrOdds;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] bounds = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = scanner.nextLine();

        int lowerBound = bounds[0];
        int upperBound = bounds[1];

        Predicate<Integer> isEven = num -> num % 2 == 0;
        Predicate<Integer> isOdd = num -> num % 2 != 0;


        switch(command) {
            case "odd":

        }

    }
}
