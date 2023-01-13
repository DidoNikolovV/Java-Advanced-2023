package RecursiveFibonacci;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
    }

    public static int fibonacci(int n) {
        if(n <= 1) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci( n - 2);
    }
}
