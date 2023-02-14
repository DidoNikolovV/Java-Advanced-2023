package Exam_15_December;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> males = new ArrayDeque<>();
        Deque<Integer> females = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(males::push);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(females::offer);

        int matchesCount = 0;

        while(!males.isEmpty() && !females.isEmpty()) {
            int male = males.peek();
            int female = females.peek();
            if(male <= 0) {
                males.pop();
            } else if(female <= 0) {
                females.poll();
            } else {
                if(male % 25 == 0) {
                    males.pop();
                    males.pop();
                } else if(female % 25 == 0) {
                    females.poll();
                    females.poll();
                } else {

                    if(male == female) {
                        males.pop();
                        females.poll();
                        matchesCount++;
                    } else {
                        males.pop();
                        females.poll();
                        male -= 2;
                        males.push(male);
                    }
                }
            }
        }

        System.out.println("Matches: " + matchesCount);

        if(males.size() == 0) {
            System.out.println("Males left: none");
        } else {
            System.out.printf("Males left: %s%n", String.join(", ", males.toString().replaceAll("[\\[\\]]", "")));
        }

        if(females.size() == 0) {
            System.out.println("Females left: none");
        } else {
            System.out.printf("Females left: %s%n", String.join(", ", females.toString().replaceAll("[\\[\\]]", "")));
        }
    }

}
