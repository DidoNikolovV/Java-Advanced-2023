package MatchingBrackets;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '(') {
                stack.push(i);
            } else if(input.charAt(i) == ')') {
                int lastOpeningBracketIndex = stack.pop();
                System.out.println(input.substring(lastOpeningBracketIndex, i + 1));
            }
        }
    }
}
