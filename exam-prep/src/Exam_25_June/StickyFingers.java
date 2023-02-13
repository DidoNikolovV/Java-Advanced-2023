package Exam_25_June;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> directions = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(","))
                .forEach(directions::offer);

        String[][] field = new String[size][size];

        int totalStolenMoney = 0;

        boolean isCaught = false;

        int playerRow = -1;
        int playerCol = -1;

        for (int row = 0; row < size; row++) {
            field[row] = scanner.nextLine().split(" ");

            for (int col = 0; col < size; col++) {
                if(field[row][col].equals("D")) {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }

        while(directions.size() > 0) {
            String direction = directions.poll();

            if(direction.equals("up")) {
                if(isOutOfBounds(field, playerRow - 1, playerCol)) {
                    System.out.println("You cannot leave the town, there is police outside!");
                } else if(isHouse(field, playerRow - 1, playerCol)) {
                    field[playerRow][playerCol] = "+";
                    playerRow--;
                    totalStolenMoney+= playerRow * playerCol;
                    field[playerRow][playerCol] = "D";
                    System.out.printf("You successfully stole %d$.%n", playerCol * playerRow);
                } else if(isPolice(field, playerRow - 1, playerCol)) {
                    field[playerRow][playerCol] = "+";
                    playerRow--;
                    field[playerRow][playerCol] = "#";
                    System.out.printf("You got caught with %d$, and you are going to jail.%n", totalStolenMoney);
                    isCaught = true;
                    break;
                }else {
                    field[playerRow][playerCol] = "+";
                    playerRow--;
                    field[playerRow][playerCol] = "D";
                }
            } else if(direction.equals("down")) {
                if(isOutOfBounds(field, playerRow + 1, playerCol)) {
                    System.out.println("You cannot leave the town, there is police outside!");
                } else if(isHouse(field, playerRow + 1, playerCol)) {
                    field[playerRow][playerCol] = "+";
                    playerRow++;
                    totalStolenMoney+= playerRow * playerCol;
                    field[playerRow][playerCol] = "D";
                    System.out.printf("You successfully stole %d$.%n", playerCol * playerRow);
                } else if(isPolice(field, playerRow + 1, playerCol)) {
                    field[playerRow][playerCol] = "+";
                    playerRow++;
                    field[playerRow][playerCol] = "#";
                    System.out.printf("You got caught with %d$, and you are going to jail.%n", totalStolenMoney);
                    isCaught = true;
                    break;
                } else {
                    field[playerRow][playerCol] = "+";
                    playerRow++;
                    field[playerRow][playerCol] = "D";
                }
            } else if(direction.equals("left")) {
                if(isOutOfBounds(field, playerRow, playerCol - 1)) {
                    System.out.println("You cannot leave the town, there is police outside!");
                } else if(isHouse(field, playerRow, playerCol - 1)) {
                    field[playerRow][playerCol] = "+";
                    playerCol--;
                    totalStolenMoney+= playerRow * playerCol;
                    field[playerRow][playerCol] = "D";
                    System.out.printf("You successfully stole %d$.%n", playerCol * playerRow);
                } else if(isPolice(field, playerRow, playerCol - 1)) {
                    field[playerRow][playerCol] = "+";
                    playerCol--;
                    field[playerRow][playerCol] = "#";
                    System.out.printf("You got caught with %d$, and you are going to jail.%n", totalStolenMoney);
                    isCaught = true;
                    break;
                } else {
                    field[playerRow][playerCol] = "+";
                    playerCol--;
                    field[playerRow][playerCol] = "D";
                }
            } else if(direction.equals("right")) {
                if(isOutOfBounds(field, playerRow, playerCol + 1)) {
                    System.out.println("You cannot leave the town, there is police outside!");
                } else if(isHouse(field, playerRow, playerCol + 1)) {
                    field[playerRow][playerCol] = "+";
                    playerCol++;
                    totalStolenMoney+= playerRow * playerCol;
                    field[playerRow][playerCol] = "D";
                    System.out.printf("You successfully stole %d$.%n", playerCol * playerRow);
                } else if(isPolice(field, playerRow, playerCol + 1)) {
                    field[playerRow][playerCol] = "+";
                    playerCol++;
                    field[playerRow][playerCol] = "#";
                    System.out.printf("You got caught with %d$, and you are going to jail.%n", totalStolenMoney);
                    isCaught = true;
                    break;
                } else {
                    field[playerRow][playerCol] = "+";
                    playerCol++;
                    field[playerRow][playerCol] = "D";
                }
            }


        }

        if(!isCaught) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", totalStolenMoney);
        }

        printField(field);
    }

    public static boolean isOutOfBounds(String[][] field, int row, int col) {
        return row < 0 || row >= field.length || col < 0 || col >= field[row].length;
    }

    public static boolean isHouse(String[][] field, int row, int col) {
        return field[row][col].equals("$");
    }

    public static boolean isPolice(String[][] field, int row, int col) {
        return field[row][col].equals("P");
    }

    public static void printField(String[][] field) {
        for (String[] row : field) {
            for (String col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

}
