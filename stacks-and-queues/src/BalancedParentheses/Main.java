package BalancedParentheses;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();

        ArrayDeque<Character> openingParentheses = new ArrayDeque<>();
        ArrayDeque<Character> closingParentheses = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char currentBracket = input.charAt(i);
            if(currentBracket == '(' || currentBracket == '{' || currentBracket == '[') {
                openingParentheses.offer(currentBracket);
            } else if(currentBracket == ')' || currentBracket == '}' || currentBracket == ']') {
                closingParentheses.push(currentBracket);
            }
        }

        boolean areBalanced = true;
        if(openingParentheses.size() == closingParentheses.size()) {
            while(openingParentheses.size() > 0) {
                char currentOpeningBracket = openingParentheses.poll();
                char currentClosingBracket = closingParentheses.pop();
                if(currentOpeningBracket == '(' && (currentClosingBracket == '}' || currentClosingBracket == ']')) {
                    areBalanced = false;
                } else if(currentOpeningBracket == '{' && (currentClosingBracket == ')' || currentClosingBracket == ']')) {
                    areBalanced = false;
                } else if(currentOpeningBracket == '[' && (currentClosingBracket == ')' || currentClosingBracket == '}')) {
                    areBalanced = false;
                }
            }
        } else {
            areBalanced = false;
        }

        if(areBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
