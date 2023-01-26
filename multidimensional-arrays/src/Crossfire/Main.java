package Crossfire;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = new int[rows][cols];

        int counter = 1;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = counter;
                counter++;
            }
        }

        String[][] stringMatrix = parseMatrixToString(rows, cols, matrix);

        String input = scanner.nextLine();

        while(!input.equals("Nuke it from orbit")) {
            String[] tokens = input.split("\\s+");
            int row = Integer.parseInt(tokens[0]);
            int col = Integer.parseInt(tokens[1]);
            int radius = Integer.parseInt(tokens[2]);

            destroyRight(stringMatrix, row, col, radius);
            destroyLeft(stringMatrix, row, col, radius);
            destroyUp(stringMatrix, row, col, radius);
            destroyDown(stringMatrix, row, col, radius);

            input = scanner.nextLine();
        }

        printMatrix(matrix);

    }

    private static void destroyRight(String[][] stringMatrix, int row, int col, int radius) {
        for (int c = col + 1; c < col + radius + 1; c++) {
            if(isInBounds(row, c, stringMatrix)) {
                stringMatrix[row][c] = "";
            }
        }
    }

    private static void destroyLeft(String[][] stringMatrix, int row, int col, int radius) {
        for (int c = col; c < col - radius - 1; c--) {
            if(isInBounds(row, c, stringMatrix)) {
                stringMatrix[row][c] = "";
            }
        }
    }

    private static void destroyUp(String[][] stringMatrix, int row, int col, int radius) {
        for (int r = row - 1; r > row - radius - 1; r--) {
            if(isInBounds(r, col, stringMatrix)) {
                stringMatrix[r][col] = "";
            }
        }
    }

    private static void destroyDown(String[][] stringMatrix, int row, int col, int radius) {
        for (int r = row + 1; r < row + radius + 1; r++) {
            if(isInBounds(r, col, stringMatrix)) {
                stringMatrix[r][col] = "";
            }
        }
    }

    private static boolean isInBounds(int row, int col, String[][]matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static String[][] parseMatrixToString(int rows, int cols, int[][] matrix) {
        String[][] newMatrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                newMatrix[row][col] = String.valueOf(matrix[row][col]);
            }
        }

        return newMatrix;
    }
}
