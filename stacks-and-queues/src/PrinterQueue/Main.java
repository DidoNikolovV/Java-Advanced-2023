package PrinterQueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        Deque<String> queue = new ArrayDeque<>();

        while(!command.equals("print")) {
            if(command.equals("cancel")) {
                if(queue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + queue.poll());
                }
            } else {
                queue.offer(command);
            }
            command = scanner.nextLine();
        }

        queue.forEach(System.out::println);
    }
}
