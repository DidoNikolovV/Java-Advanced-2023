package SimpleCalculator;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] expression = scanner.nextLine().split("\\s+");
        Deque<String> stack = new ArrayDeque<>();

        for (int i = expression.length - 1; i >=0 ; i--) {
            stack.push(expression[i]);
        }

        while(stack.size() > 1) {
            int firstNumber = Integer.parseInt(stack.pop());
            String operation = stack.pop();
            int secondNumber = Integer.parseInt(stack.pop());

            int result = 0;
            switch(operation) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
            }

            stack.push("" + result);
        }

        System.out.println(stack.pop());

    }
}
