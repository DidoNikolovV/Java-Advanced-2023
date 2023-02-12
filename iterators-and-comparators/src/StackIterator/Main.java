package StackIterator;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        Stack stack = new Stack();

        while(!command.equals("END")) {
            String[] cmdParts = command.split(" ");
            String commandName = cmdParts[0];


            switch(commandName) {
                case "Push":
                    for (int i = 1; i < cmdParts.length; i++) {
                        Integer num = Integer.parseInt(String.valueOf(cmdParts[i].charAt(0)));
                        stack.push(num);
                    }
                    break;
                case "Pop":
                    try {
                        stack.pop();

                    } catch(IllegalStateException ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
            }

            command = scanner.nextLine();
        }

        for (Integer integer : stack) {
            System.out.println(integer);
        }

        for (Integer integer : stack) {
            System.out.println(integer);
        }

    }
}
