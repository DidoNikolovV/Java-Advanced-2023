package BrowserHistory;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Deque<String> urls = new ArrayDeque<>();

        while(!input.equals("Home")) {
            if(input.equals("back")) {
                if(urls.size() > 1) {
                    urls.pop();
                } else {
                    System.out.println("no previous URLs");
                    input = scanner.nextLine();
                    continue;
                }
            } else {
                urls.push(input);
            }
            System.out.println(urls.peek());
            input = scanner.nextLine();
        }
    }
}