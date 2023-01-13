package BasicStackOperations;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int numbersOfElementsToAdd = input[0];
        int numberOfElementsToPop = input[1];
        int number = input[2];

        int[] sequenceOfNumbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numbersOfElementsToAdd; i++) {
            stack.push(sequenceOfNumbers[i]);
        }

        for (int i = 0; i < numberOfElementsToPop; i++) {
            stack.pop();
        }

        if(stack.isEmpty()) {
            System.out.println(0);
        } else {
            if(stack.contains(number)) {
                System.out.println(true);
            } else {
                int minValue = Integer.MAX_VALUE;
                for (Integer integer : stack) {
                    if(integer < minValue) {
                        minValue = integer;
                    }
                }

                System.out.println(minValue);
            }
        }







    }
}
