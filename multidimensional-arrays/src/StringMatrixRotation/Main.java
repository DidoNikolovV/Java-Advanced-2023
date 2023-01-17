package StringMatrixRotation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // From top to bottom -> row++;
        // From bottom to top -> row--;
        // From left to right -> col++;
        // From right to left -> col--;

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int rotation = Integer.parseInt(input.split("[()]")[1]);
        int angleOfRotation = rotation % 360;
        List<String> words = new ArrayList<>();
        String line = scanner.nextLine();
        int maxLength = Integer.MIN_VALUE;
        while(!line.equals("END")) {
            words.add(line);

            if(line.length() > maxLength) {
                maxLength = line.length();
            }

            line = scanner.nextLine();
        }

        int rows = words.size();
        int cols = maxLength;

        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            String currentWord = words.get(row);
            for (int col = 0; col < matrix[row].length; col++) {
                if(col < currentWord.length()) {
                    char currentChar = words.get(row).charAt(col);
                    matrix[row][col] = currentChar;
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }

        switch(angleOfRotation) {
            case 0:
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 90:
                for (int col = 0; col < cols; col++) {
                    for (int row = rows - 1; row >= 0; row--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 180:
                for (int row = rows - 1; row >= 0; row--) {
                    for (int col = cols - 1; col >= 0; col--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 270:
                for (int col = cols - 1; col >= 0; col--) {
                    for(int row = 0; row < rows; row++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
        }


    }
}
