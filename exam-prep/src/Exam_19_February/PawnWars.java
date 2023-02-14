package Exam_19_February;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = 8;
        int cols = 8;
        char[][] board = new char[8][8];

        Map<Integer, Character> columnLetters = new HashMap<>();
        columnLetters.put(0, 'a');
        columnLetters.put(1, 'b');
        columnLetters.put(2, 'c');
        columnLetters.put(3, 'd');
        columnLetters.put(4, 'e');
        columnLetters.put(5, 'f');
        columnLetters.put(6, 'g');
        columnLetters.put(7, 'h');

        Map<Integer, Integer> rowNumbers = new HashMap<>();
        rowNumbers.put(0, 8);
        rowNumbers.put(1, 7);
        rowNumbers.put(2, 6);
        rowNumbers.put(3, 5);
        rowNumbers.put(4, 4);
        rowNumbers.put(5, 3);
        rowNumbers.put(6, 2);
        rowNumbers.put(7, 1);

        int blackRow = -1;
        int blackCol = -1;

        int whiteRow = -1;
        int whiteCol = -1;

        for (int row = 0; row < rows; row++) {
            board[row] = scanner.nextLine().toCharArray();

            for (int col = 0; col < cols; col++) {
                if(board[row][col] == 'b') {
                    blackRow = row;
                    blackCol = col;
                } else if(board[row][col] == 'w') {
                    whiteRow = row;
                    whiteCol = col;
                }
            }
        }

        boolean pawnIsCaptured = false;
        boolean pawnIsPromotedToQueen = false;
        int round = 1;

        while(!pawnIsCaptured && !pawnIsPromotedToQueen) {
            if(round % 2 != 0) {
                if(board[whiteRow-1][whiteCol - 1] == 'b') {
                    char currentColumn = columnLetters.get(whiteCol-1);
                    int currentRow = rowNumbers.get(whiteRow - 1);
                    System.out.printf("Game over! White capture on %s%d.",currentColumn, currentRow);
                    pawnIsCaptured = true;
                    continue;
                } else if(board[whiteRow - 1][whiteCol + 1] == 'b') {
                    char currentColumn = columnLetters.get(whiteCol+1);
                    int currentRow = rowNumbers.get(whiteRow -1);
                    System.out.printf("Game over! White capture on %s%d.", currentColumn, currentRow);
                    pawnIsCaptured = true;
                    continue;
                } else if(rowNumbers.get(whiteRow-1) == 8) {
                    char currentColumn = columnLetters.get(whiteCol);
                    int currentRow = rowNumbers.get(whiteRow - 1);
                    pawnIsPromotedToQueen = true;
                    System.out.printf("Game over! White pawn is promoted to a queen at %s%d.", currentColumn, currentRow);
                    continue;
                } else {
                    board[whiteRow--][whiteCol] = '-';
                    board[whiteRow][whiteCol] = 'w';
                }
            } else {
                if(board[blackRow+1][blackCol + 1] == 'w') {
                    char currentColumn = columnLetters.get(whiteCol+1);
                    int currentRow = rowNumbers.get(whiteRow + 1);
                    System.out.printf("Game over! Black capture on %s%d.",currentColumn, currentRow);
                    pawnIsCaptured = true;
                    continue;
                } else if(board[blackRow + 1][blackCol - 1] == 'w') {
                    char currentColumn = columnLetters.get(blackCol-1);
                    int currentRow = rowNumbers.get(blackRow +1);
                    System.out.printf("Game over! Black capture on %s%d.", currentColumn, currentRow);
                    pawnIsCaptured = true;
                    continue;
                } else if(rowNumbers.get(blackRow+1) == 1) {
                    char currentColumn = columnLetters.get(blackCol);
                    int currentRow = rowNumbers.get(blackRow + 1);
                    pawnIsPromotedToQueen = true;
                    System.out.printf("Game over! Black pawn is promoted to a queen at %s%d.", currentColumn, currentRow);
                    continue;
                } else {
                    board[blackRow++][blackCol] = '-';
                    board[blackRow][blackCol] = 'b';
                }
            }
            round++;

        }

    }

}
