package Exam_15_December;

import java.util.Scanner;

public class ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int parisEnergy = Integer.parseInt(scanner.nextLine());

        int size = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[size][size];

        int parisRow = -1;
        int parisCol = -1;
        int helenRow = -1;
        int helenCol = -1;

        for (int row = 0; row < size; row++) {
            field[row] = scanner.nextLine().toCharArray();

            for (int col = 0; col < size; col++) {
                if(field[row][col] == 'P') {
                    parisRow = row;
                    parisCol = col;
                } else if(field[row][col] == 'H') {
                    helenRow = row;
                    helenCol = col;
                }
            }
        }

        boolean isHelenAbducted = false;
        while(parisEnergy != 0 && !isHelenAbducted) {
            String[] command = scanner.nextLine().split("\\s+");
            String direction = command[0];
            int spawnRow = Integer.parseInt(command[1]);
            int spawnCol = Integer.parseInt(command[2]);

            field[spawnRow][spawnCol] = 'S';


            if(direction.equals("up")) {
                parisRow--;
                parisEnergy--;
                if(isInBounds(field, parisRow, parisCol)) {
                    field[parisRow + 1][parisCol] = '-';
                    if(isEnemy(field, parisRow, parisCol)) {
                        parisEnergy -=2;
                        field[parisRow][parisCol] = 'P';
                    } else if(isHelen(field, parisRow, parisCol)) {
                        field[parisRow + 1][parisCol] = '-';
                        isHelenAbducted = true;
                        continue;
                    } else {
                        field[parisRow][parisCol] = 'P';
                        field[parisRow + 1][parisCol] = '-';
                    }
                } else {
                    parisRow++;
                }
            } else if(direction.equals("down")) {
                parisRow++;
                parisEnergy--;
                if(isInBounds(field, parisRow, parisCol)) {
                    field[parisRow - 1][parisCol] = '-';
                    if(isEnemy(field, parisRow, parisCol)) {
                        parisEnergy -=2;
                        field[parisRow][parisCol] = 'P';
                    } else if(isHelen(field, parisRow, parisCol)) {
                        field[parisRow - 1][parisCol] = '-';
                        isHelenAbducted = true;
                        break;
                    } else {
                        field[parisRow][parisCol] = 'P';
                        field[parisRow - 1][parisCol] = '-';
                    }
                } else {
                    parisRow--;
                }
            } else if(direction.equals("left")) {
                parisCol--;
                parisEnergy--;
                if(isInBounds(field, parisRow, parisCol)) {
                    field[parisRow][parisCol + 1] = '-';
                    if(isEnemy(field, parisRow, parisCol)) {
                        parisEnergy -=2;
                        field[parisRow][parisCol] = 'P';
                    } else if(isHelen(field, parisRow, parisCol)) {
                        field[parisRow][parisCol + 1] = '-';
                        isHelenAbducted = true;
                        break;
                    }else {
                        field[parisRow][parisCol] = 'P';
                        field[parisRow][parisCol + 1] = '-';
                    }
                } else {
                    parisCol++;
                }
            } else if(direction.equals("right")) {
                parisCol++;
                parisEnergy--;
                if(isInBounds(field, parisRow, parisCol)) {
                    field[parisRow][parisCol - 1] = '-';
                    if(isEnemy(field, parisRow, parisCol)) {
                        parisEnergy -=2;
                        field[parisRow][parisCol] = 'P';
                    } else if(isHelen(field, parisRow, parisCol)) {
                        field[parisRow][parisCol - 1] = '-';
                        isHelenAbducted = true;
                        break;
                    } else {
                        field[parisRow][parisCol] = 'P';
                        field[parisRow][parisCol - 1] = '-';
                    }
                } else {
                    parisCol--;
                }
            }

        }

        if(isHelenAbducted) {
            field[parisRow][parisCol] = '-';
            System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", parisEnergy);
        }

        if(parisEnergy <=0) {
            field[parisRow][parisCol] = 'X';
            System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
        }

        printField(field);
    }

    public static boolean isInBounds(char[][] field, int row, int col) {
        return row >= 0 && row < field.length && col >= 0 && col < field[row].length;
    }

    public static boolean isEnemy(char[][] field, int row, int col) {
        return field[row][col] == 'S';
    }

    public static boolean isHelen(char[][] field, int row, int col) {
        return field[row][col] == 'H';
    }

    public static void printField(char[][] field) {
        for (char[] arr : field) {
            for (char c : arr) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
