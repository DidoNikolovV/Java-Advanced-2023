package DecimalToBinary;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decimal = Integer.parseInt(scanner.nextLine());

        Deque<String> stack = new ArrayDeque<>();

        if(decimal == 0) {
            System.out.println(0);
        } else {
            while(decimal != 0) {
                int remainder = decimal % 2;
                stack.push("" + remainder);
                decimal /= 2;
            }

            while(stack.size() > 0) {
                System.out.print(stack.pop());
            }
        }
    }
}
