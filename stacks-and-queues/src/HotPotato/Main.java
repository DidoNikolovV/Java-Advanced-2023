package HotPotato;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int toss = Integer.parseInt(scanner.nextLine());

        Deque<String> queue = new ArrayDeque<>();
        for(String s :  input) {
            queue.offer(s);
        }

        Deque<String> removedKids = new ArrayDeque<>();

        int currentToss = 1;
        while(queue.size() > 1) {
            if(currentToss % toss  == 0) {
                removedKids.offer(queue.poll());
            } else {
                queue.offer(queue.poll());
            }
            currentToss++;
        }

        while(removedKids.size() > 0) {
            System.out.println("Removed " + removedKids.poll());
        }

        System.out.println("Last is " + queue.poll());

    }
}
