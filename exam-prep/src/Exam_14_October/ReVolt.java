package Exam_14_October;

import java.util.Scanner;

public class ReVolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int nCommands = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        int playerRow = -1;
        int playerCol = -1;

        for (int row = 0; row < size; row++) {
            matrix[row] = scanner.nextLine().toCharArray();

            for (int col = 0; col < size; col++) {
                if(matrix[row][col] == 'f') {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }


        boolean hasWon = false;

        for (int i = 0; i < nCommands; i++) {
            String direction = scanner.nextLine();

            if(direction.equals("down")) {
                matrix[playerRow][playerCol] = '-';

                if(isOutOfBounds(matrix, playerRow + 1, playerCol)) {
                    playerRow = -1;
                }


                if(matrix[playerRow + 1][playerCol] == 'B') {
                    if(isOutOfBounds(matrix, playerRow + 2, playerCol)) {
                        playerRow = 0;
                    }
                    playerRow+= 2;
                } else if(matrix[playerRow + 1][playerCol] == 'T') {
                    continue;
                } else {
                    playerRow++;
                }

                if(matrix[playerRow][playerCol] == 'F') {
                    hasWon = true;
                    matrix[playerRow][playerCol] = 'f';
                    break;
                }

                if(isOutOfBounds(matrix, playerRow, playerCol)) {
                    playerRow = -1;
                }

                matrix[playerRow][playerCol] = 'f';
            } else if(direction.equals("up")) {
                matrix[playerRow][playerCol] = '-';

                if(isOutOfBounds(matrix, playerRow - 1, playerCol)) {
                    playerRow = matrix.length;
                }

                if(matrix[playerRow - 1][playerCol] == 'B') {
                    if(isOutOfBounds(matrix, playerRow - 2, playerCol)) {
                        playerRow = matrix.length - 1;
                    }
                    playerRow-= 2;
                } else if(matrix[playerRow -1][playerCol] == 'T') {
                    continue;
                } else {
                    playerRow--;
                }

                if(matrix[playerRow][playerCol] == 'F') {
                    hasWon = true;
                    matrix[playerRow][playerCol] = 'f';
                    break;
                }



                matrix[playerRow][playerCol] = 'f';
            } else if(direction.equals("right")) {
                matrix[playerRow][playerCol] = '-';

                if(isOutOfBounds(matrix, playerRow, playerCol + 1)) {
                    playerCol = -1;
                }

                if(matrix[playerRow][playerCol + 1] == 'B') {
                    if(isOutOfBounds(matrix, playerRow, playerCol + 2)) {
                        playerCol = 0;
                    }
                    playerCol+= 2;
                } else if(matrix[playerRow][playerCol + 1] == 'T') {
                    continue;
                } else {
                    playerCol++;
                }

                if(matrix[playerRow][playerCol] == 'F') {
                    hasWon = true;
                    matrix[playerRow][playerCol] = 'f';
                    break;
                }

                if(isOutOfBounds(matrix, playerRow, playerCol)) {
                    playerCol = 0;
                }

                matrix[playerRow][playerCol] = 'f';
            } else if(direction.equals("left")) {
                matrix[playerRow][playerCol] = '-';

                if(isOutOfBounds(matrix, playerRow, playerCol - 1)) {
                    playerCol = matrix.length;
                }

                if(matrix[playerRow][playerCol - 1] == 'B') {
                    if(isOutOfBounds(matrix, playerRow, playerCol - 2)) {
                        playerCol = matrix.length - 1;
                    }
                    playerCol-= 2;
                } else if(matrix[playerRow][playerCol - 1] == 'T') {
                    continue;
                } else {
                    playerCol--;
                }

                if(matrix[playerRow][playerCol] == 'F') {
                    hasWon = true;
                    matrix[playerRow][playerCol] = 'f';
                    break;
                }

                if(isOutOfBounds(matrix, playerRow, playerCol)) {
                    playerCol = matrix.length - 1;
                }
                matrix[playerRow][playerCol] = 'f';
            }

        }

        if(hasWon) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }

        printMatrix(matrix);
    }

    private static boolean isOutOfBounds(char[][] matrix, int row, int col) {
        return row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length;
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char ch : chars) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}
