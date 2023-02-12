package Exam_18_Augst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = size[0];
        int cols = size[1];

        String[][] matrix = new String[rows][cols];

        int playerRow = -1;
        int playerCol = -1;

        for (int row = 0; row < rows; row++) {
            String[] currentRow = scanner.nextLine().split(" ");
            matrix[row] = currentRow;
            for (int col = 0; col < cols; col++) {
                if(matrix[row][col].equals("Y")) {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }

        String line = scanner.nextLine();

        boolean isFound = false;
        List<String> path = new ArrayList<>();
        while(!line.equals("Finish")) {
            String direction = line;

            if(direction.equals("up")) {
                if(isOutOfBounds(matrix, playerRow - 1, playerCol) || isTree(matrix, playerRow - 1, playerCol))  {
                    line = scanner.nextLine();
                    continue;
                }

                if(isTreasure(matrix, playerRow - 1, playerCol)) {
                    isFound = true;
                    playerRow--;
                    matrix[playerRow][playerCol].concat("Y");
                    path.add("up");
                } else {
                    matrix[playerRow][playerCol] = "-";
                    playerRow--;
                    matrix[playerRow][playerCol] = "Y";
                    path.add("up");
                }

            } else if(direction.equals("down")) {
                if(isOutOfBounds(matrix, playerRow + 1, playerCol) || isTree(matrix, playerRow + 1, playerCol))  {
                    line = scanner.nextLine();
                    continue;
                }

                if(isTreasure(matrix, playerRow + 1, playerCol)) {
                    isFound = true;
                    playerRow++;
                    matrix[playerRow][playerCol].concat("Y");
                    path.add("down");
                } else {
                    matrix[playerRow][playerCol] = "-";
                    playerRow++;
                    matrix[playerRow][playerCol] = "Y";
                    path.add("down");
                }


            } else if(direction.equals("left")) {
                if(isOutOfBounds(matrix, playerRow, playerCol - 1) || isTree(matrix, playerRow, playerCol - 1))  {
                    line = scanner.nextLine();
                    continue;
                }

                if(isTreasure(matrix, playerRow, playerCol - 1)) {
                    isFound = true;
                    playerCol--;
                    matrix[playerRow][playerCol].concat("Y");
                    path.add("left");
                } else {
                    matrix[playerRow][playerCol] = "-";
                    playerCol--;
                    matrix[playerRow][playerCol] = "Y";
                    path.add("left");
                }


            } else if(direction.equals("right")) {
                if(isOutOfBounds(matrix, playerRow, playerCol + 1) || isTree(matrix, playerRow, playerCol + 1))  {
                    continue;
                }

                if(isTreasure(matrix, playerRow, playerCol + 1)) {
                    isFound = true;
                    playerCol++;
                    matrix[playerRow][playerCol].concat("Y");
                    path.add("right");
                } else {
                    matrix[playerRow][playerCol] = "-";
                    playerCol++;
                    matrix[playerRow][playerCol] = "Y";
                    path.add("right");
                }


            }
            line = scanner.nextLine();
        }


        if(isFound) {
            System.out.println("I've found the treasure!");
            System.out.printf("The right path is %s", String.join(", ", path));
        } else {
            System.out.println("The map is fake!");
        }


    }

    public static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    public static boolean isOutOfBounds(String[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

    public static boolean isTree(String[][] matrix, int row, int col) {
        return matrix[row][col].equals("T");
    }

    public static boolean isTreasure(String[][] matrix, int row, int col) {
        return matrix[row][col].equals("X");
    }
}
