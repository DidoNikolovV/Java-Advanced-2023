package PositionsOf;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = input[0];
        int cols = input[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int searchedNumber = Integer.parseInt(scanner.nextLine());

        boolean isFound = false;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
               if(matrix[row][col] == searchedNumber) {
                   System.out.println(row + " " + col);
                   isFound = true;
               }
            }
        }

        if(!isFound) {
            System.out.println("not found");
        }


    }
}
