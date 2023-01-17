package StringMatrixRotation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int degrees = Integer.parseInt(input.substring(input.indexOf('(') + 1, input.indexOf(')')));


        String line = scanner.nextLine();
        while(!line.equals("END")) {
            String text = line;

            line = scanner.nextLine();
        }

    }
}
