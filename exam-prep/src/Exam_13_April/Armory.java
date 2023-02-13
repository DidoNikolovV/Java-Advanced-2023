package Exam_13_April;

import java.util.Scanner;

public class Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] field = new String[size][size];

        int playerRow = -1;
        int playerCol = -1;

        int firstMirrorRow = -1;
        int firstMirrowCol = -1;
        int secondMirrorRow = -1;
        int secondMirrorCol = -1;

        int totalCoins = 0;

        boolean isOutOfArmory = false;
        boolean hasBoughtEnoughBlades = false;

        for (int row = 0; row < size; row++) {
            field[row] = scanner.nextLine().split("");

            for (int col = 0; col < size; col++) {
                if(field[row][col].equals("A")) {
                    playerRow = row;
                    playerCol = col;
                } else if(field[row][col].equals("M")) {
                    if(firstMirrorRow == -1) {
                        firstMirrorRow = row;
                        firstMirrowCol = col;
                    } else {
                        secondMirrorRow = row;
                        secondMirrorCol = col;
                    }
                }
            }
        }



        while(!hasBoughtEnoughBlades && !isOutOfArmory) {
            String direction = scanner.nextLine();

            if(direction.equals("up")) {
                if(isOutOfBounds(playerRow - 1, playerCol, field)) {
                    isOutOfArmory = true;
                } else if(isMirror(playerRow - 1, playerCol, field)) {
                    field[playerRow][playerCol] = "-";
                    field[playerRow - 1][playerCol] = "-";
                    playerRow = secondMirrorRow;
                    playerCol = secondMirrorCol;
                    field[playerRow][playerCol] = "A";
                } else if(isSword(playerRow - 1, playerCol, field)) {
                    totalCoins += Integer.parseInt(field[playerRow - 1][playerCol]);
                    field[playerRow][playerCol] = "-";
                    playerRow--;
                    field[playerRow][playerCol] = "A";
                } else {
                    field[playerRow][playerCol] = "-";
                    playerRow--;
                    field[playerRow][playerCol] = "A";
                }
            } else if(direction.equals("down")) {
                if(isOutOfBounds(playerRow + 1, playerCol, field)) {
                    isOutOfArmory = true;
                } else if(isMirror(playerRow + 1, playerCol, field)) {
                    field[playerRow][playerCol] = "-";
                    field[playerRow + 1][playerCol] = "-";
                    playerRow = secondMirrorRow;
                    playerCol = secondMirrorCol;
                    field[playerRow][playerCol] = "A";
                } else if(isSword(playerRow + 1, playerCol, field)) {
                    totalCoins += Integer.parseInt(field[playerRow + 1][playerCol]);
                    field[playerRow][playerCol] = "-";
                    playerRow++;
                    field[playerRow][playerCol] = "A";
                } else {
                    field[playerRow][playerCol] = "-";
                    playerRow++;
                    field[playerRow][playerCol] = "A";
                }
            } else if(direction.equals("left")) {
                if(isOutOfBounds(playerRow, playerCol - 1, field)) {
                    isOutOfArmory = true;
                } else if(isMirror(playerRow, playerCol - 1, field)) {
                    field[playerRow][playerCol] = "-";
                    field[playerRow][playerCol - 1] = "-";
                    playerRow = secondMirrorRow;
                    playerCol = secondMirrorCol;
                    field[playerRow][playerCol] = "A";
                } else if(isSword(playerRow, playerCol - 1, field)) {
                    totalCoins += Integer.parseInt(field[playerRow][playerCol -1]);
                    field[playerRow][playerCol] = "-";
                    playerCol--;
                    field[playerRow][playerCol] = "A";
                } else {
                    field[playerRow][playerCol] = "-";
                    playerCol--;
                    field[playerRow][playerCol] = "A";
                }
            }  else if(direction.equals("right")) {
                if(isOutOfBounds(playerRow, playerCol + 1, field)) {
                    isOutOfArmory = true;
                } else if(isMirror(playerRow, playerCol + 1, field)) {
                    field[playerRow][playerCol] = "-";
                    field[playerRow][playerCol + 1] = "-";
                    playerRow = secondMirrorRow;
                    playerCol = secondMirrorCol;
                    field[playerRow][playerCol] = "A";
                } else if(isSword(playerRow, playerCol + 1, field)) {
                    totalCoins += Integer.parseInt(field[playerRow][playerCol +1]);
                    field[playerRow][playerCol] = "-";
                    playerCol++;
                    field[playerRow][playerCol] = "A";
                } else {
                    field[playerRow][playerCol] = "-";
                    playerCol++;
                    field[playerRow][playerCol] = "A";
                }
            }

            if(totalCoins >= 65) {
                hasBoughtEnoughBlades = true;
            }

        }

        if(isOutOfArmory) {
            field[playerRow][playerCol] = "-";
            System.out.println("I do not need more swords!");
        } else if(hasBoughtEnoughBlades) {
            System.out.println("Very nice swords, I will come back for more!");
        }

        System.out.printf("The king paid %d gold coins.%n", totalCoins);

        printField(field);

    }


    public static boolean isSword(int row, int col, String[][] field) {
        char ch = field[row][col].toCharArray()[0];
        return Character.isDigit(ch);
    }

    public static boolean isMirror(int row, int col, String[][] field) {
        return field[row][col].equals("M");
    }

    public static boolean isOutOfBounds(int row, int col, String[][] field) {
        return row < 0 || row >= field.length || col < 0 || col >= field[row].length;
    }

    public static void printField(String[][] field) {
        for (String[] row : field) {
            for (String s : row) {
                System.out.print(s + "");
            }
            System.out.println();
        }
    }
}
