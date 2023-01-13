package MathPotato;

import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        PriorityQueue<String> kids = new PriorityQueue<>();
        for (String s : input) {
            kids.offer(s);
        }

        int cycles = Integer.parseInt(scanner.nextLine());

        int currentCycle = 1;

        while(kids.size() > 1) {
            for(int i = 1; i < cycles; i++) {
                String kid = kids.poll();
                kids.offer(kid);
            }

            if(isPrime(currentCycle)) {
                System.out.println("Prime " + kids.peek());
            } else {
                String removedChild = kids.poll();
                System.out.println("Removed " + removedChild);
            }

            currentCycle++;
        }

        System.out.println("Last is " + kids.poll());

    }

    public static boolean isPrime(int num) {
        if(num <= 1) {
            return false;
        }

        for(int i = 2 ; i < num; i++) {
            if(num % i == 0) {
                return false;
            }
        }

        return true;
    }
}
