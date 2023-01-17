package FillTheMatrix;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputData = scanner.nextLine().split(", ");
        int size = Integer.parseInt(inputData[0]);
        int[][] matrix = new int[size][size];
        String pattern = inputData[1];
        if(pattern.equals("A")) {
            fillPatternA(matrix);
        } else if(pattern.equals("B")) {
            fillPatternB(matrix);

        }

        for (int[] arr : matrix) {
            for(int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }

    public static void fillPatternA(int[][] matrix) {
        int start = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix[col].length; row++) {
                matrix[row][col] = start++;
            }
        }
    }


    public static void fillPatternB(int[][] matrix) {
        int start = 1;
        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix[col].length; row++) {
                if(col % 2 == 0) {
                    matrix[row][col] = start++;
                } else {
                    matrix[matrix.length - 1 - row][col] = start++;
                }
            }
        }
    }
}
