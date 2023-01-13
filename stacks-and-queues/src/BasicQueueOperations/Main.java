package BasicQueueOperations;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int elementsToEnqueue = input[0];
        int elementsToDequeue = input[1];
        int number = input[2];

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        int[] numberSequence = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < elementsToEnqueue; i++) {
            queue.offer(numberSequence[i]);
        }

        for (int i = 0; i < elementsToDequeue; i++) {
            queue.poll();
        }

        if(queue.isEmpty()) {
            System.out.println(0);
        } else {
            if(queue.contains(number)) {
                System.out.println(true);
            } else {
                int minValue = queue.stream().min(Integer::compare).get();
                System.out.println(minValue);
            }
        }
    }
}
