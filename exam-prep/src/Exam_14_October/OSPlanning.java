package Exam_14_October;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OSPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> tasks = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
        .mapToInt(Integer::parseInt)
        .forEach(tasks::push);

        ArrayDeque<Integer> threads = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(threads::offer);

        int taskToKill = Integer.parseInt(scanner.nextLine());

        boolean taskIsKilled = false;
        Integer killerThread = null;

        while(killerThread == null) {
            Integer currentTask = tasks.peek();
            Integer currentThread = threads.peek();

            if(currentTask == taskToKill) {
                killerThread = currentThread;
                System.out.printf("Thread with value %d killed task %d%n", currentThread, taskToKill);
            } else {
                if(currentThread < currentTask) {
                    threads.poll();
                } else {
                    tasks.pop();
                    threads.poll();
                }
            }
        }

        for (Integer thread : threads) {
            System.out.print(thread + " ");
        }

    }
}
