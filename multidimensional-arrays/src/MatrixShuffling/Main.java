package MatrixShuffling;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] size = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = size[0];
        int cols = size[1];
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }

        String line = scanner.nextLine();
        boolean isInvalid = false;
        while(!line.equals("END")) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            if(command.equals("swap")) {
                if(tokens.length < 5) {
                    isInvalid = true;
                } else {
                    int row1 = Integer.parseInt(tokens[1]);
                    int col1 = Integer.parseInt(tokens[2]);
                    int row2 = Integer.parseInt(tokens[3]);
                    int col2 = Integer.parseInt(tokens[4]);
                    if (isInBounds(row1, col1, matrix) && isInBounds(row2, col2, matrix)) {
                        swap(matrix, row1, col1, row2, col2);
                        printMatrix(matrix);
                    } else {
                        isInvalid = true;
                    }
                }
            } else {
                isInvalid = true;
            }

            if(isInvalid) {
                System.out.println("Invalid input!");
                isInvalid = false;
            }

            line = scanner.nextLine();
        }
    }

    public static void printMatrix(String[][] matrix) {
        for(String[] arr : matrix) {
            for(String el : arr) {
                System.out.print(el + " ");
            }

            System.out.println();
        }
    }

    public static void swap(String[][] matrix, int row1, int col1, int row2, int col2) {
        String firstValue = matrix[row1][col1];
        String secondValue = matrix[row2][col2];
        matrix[row1][col1] = secondValue;
        matrix[row2][col2] = firstValue;
    }

    private static boolean isInBounds(int row, int col, String[][]matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static boolean isOutOfBounds(int row, int col, String[][]matrix) {
        return !isInBounds(row, col, matrix);
    }
}
