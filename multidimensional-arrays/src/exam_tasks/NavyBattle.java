package exam_tasks;

import java.util.Scanner;

public class NavyBattle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[][] field = new String[n][n];
        fillMatrix(field, scanner);

        int submarineRow = 0;
        int submarineCol = 0;

        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                if(field[row][col].equals("S")) {
                    submarineRow = row;
                    submarineCol = col;
                }
            }
        }


        int counter = 3;
        int cruisers = 3;
        while(true) {
            String direction = scanner.nextLine();

            if(direction.equals("up")) {
                if(field[submarineRow - 1][submarineCol].equals("*")) {
                    counter--;
                } else if(field[submarineRow-1][submarineCol].equals("C")) {
                    cruisers--;
                }
                if(counter == 0) {
                    field[submarineRow][submarineCol] = "-";
                    field[submarineRow - 1][submarineCol] = "S";
                    submarineRow--;
                    System.out.println("Mission failed, U-9 disappeared! Last known coordinates [" + submarineRow + ", " + submarineCol + "]!");
                    break;
                }
                if(cruisers == 0) {
                    field[submarineRow][submarineCol] = "-";
                    field[submarineRow - 1][submarineCol] = "S";
                    System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                    break;
                }
                field[submarineRow][submarineCol] = "-";
                field[submarineRow - 1][submarineCol] = "S";
                submarineRow--;
            } else if(direction.equals("down")) {
                if(field[submarineRow + 1][submarineCol].equals("*")) {
                    counter--;
                } else if(field[submarineRow+1][submarineCol].equals("C")) {
                    cruisers--;
                }
                if(counter == 0) {
                    field[submarineRow][submarineCol] = "-";
                    field[submarineRow + 1][submarineCol] = "S";
                    submarineRow++;
                    System.out.println("Mission failed, U-9 disappeared! Last known coordinates [" + submarineRow + ", " + submarineCol + "]!");
                    break;
                }

                if(cruisers == 0) {
                    field[submarineRow][submarineCol] = "-";
                    field[submarineRow + 1][submarineCol] = "S";
                    System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                    break;
                }
                field[submarineRow][submarineCol] = "-";
                field[submarineRow + 1][submarineCol] = "S";
                submarineRow++;

            } else if(direction.equals("left")) {
                if(field[submarineRow][submarineCol - 1].equals("*")) {
                    counter--;
                } else if(field[submarineRow][submarineCol - 1].equals("C")) {
                    cruisers--;
                }
                if(counter == 0) {
                    field[submarineRow][submarineCol] = "-";
                    field[submarineRow][submarineCol-1] = "S";
                    submarineCol--;
                    System.out.println("Mission failed, U-9 disappeared! Last known coordinates [" + submarineRow + ", " + submarineCol + "]!");
                    break;
                }
                if(cruisers == 0) {
                    field[submarineRow][submarineCol] = "-";
                    field[submarineRow][submarineCol-1] = "S";
                    System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!%n");
                    break;
                }
                field[submarineRow][submarineCol] = "-";
                field[submarineRow][submarineCol-1] = "S";
                submarineCol--;

            } else if(direction.equals("right")) {
                if(field[submarineRow][submarineCol + 1].equals("*")) {
                    counter--;
                } else if(field[submarineRow][submarineCol + 1].equals("C")) {
                    cruisers--;

                }
                if(counter == 0) {
                    field[submarineRow][submarineCol] = "-";
                    field[submarineRow][submarineCol+1] = "S";
                    submarineCol++;
                    System.out.println("Mission failed, U-9 disappeared! Last known coordinates [" + submarineRow + ", " + submarineCol + "]!");
                    break;
                }

                if(cruisers == 0) {
                    field[submarineRow][submarineCol] = "-";
                    field[submarineRow][submarineCol + 1] = "S";
                    System.out.println("Mission accomplished, U-9 has destroyed all battle cruisers of the enemy!");
                    break;
                }
                field[submarineRow][submarineCol] = "-";
                field[submarineRow][submarineCol + 1] = "S";
                submarineCol++;

            }
        }

        printMatrix(field);
    }

    private static void fillMatrix(String[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scanner.nextLine().split("");
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + "");
            }
            System.out.println();
        }
    }
}
