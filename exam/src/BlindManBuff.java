import java.util.Arrays;
import java.util.Scanner;

public class BlindManBuff {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] size = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = size[0];
        int cols = size[1];

        String[][] playground = new String[rows][cols];

        int playerRow = -1;
        int playerCol = -1;

        int touchedOpponents = 0;
        int moves = 0;

        int opponentsCount = 0;

        for (int row = 0; row < rows; row++) {
            playground[row] = scanner.nextLine().split("\\s+");

            for (int col = 0; col < cols; col++) {
                if(playground[row][col].equals("B")) {
                    playerRow = row;
                    playerCol = col;
                } else if(playground[row][col].equals("P")) {
                    opponentsCount++;
                }
            }
        }

        String command = scanner.nextLine();
        while(!command.equals("Finish")) {
            String direction = command;

            if(direction.equals("up") && isInBounds(playerRow -1, playerCol, playground) && !isObstacle(playerRow - 1, playerCol, playground)) {
                playground[playerRow][playerCol] = "-";
                playerRow--;
                if(isOpponent(playerRow, playerCol, playground)) {
                    touchedOpponents++;
                }
                playground[playerRow][playerCol] = "B";
                moves++;
            } else if(direction.equals("down") && isInBounds(playerRow + 1, playerCol, playground) && !isObstacle(playerRow + 1, playerCol, playground)) {
                playground[playerRow][playerCol] = "-";
                playerRow++;
                if(isOpponent(playerRow, playerCol, playground)) {
                    touchedOpponents++;
                }
                playground[playerRow][playerCol] = "B";
                moves++;
            } else if(direction.equals("left") && isInBounds(playerRow, playerCol - 1, playground) && !isObstacle(playerRow, playerCol - 1, playground)) {
                playground[playerRow][playerCol] = "-";
                playerCol--;
                if(isOpponent(playerRow, playerCol, playground)) {
                    touchedOpponents++;
                }
                playground[playerRow][playerCol] = "B";
                moves++;
            } else if(direction.equals("right") && isInBounds(playerRow, playerCol + 1, playground) && !isObstacle(playerRow, playerCol + 1, playground)) {
                playground[playerRow][playerCol] = "-";
                playerCol++;
                if(isOpponent(playerRow, playerCol, playground)) {
                    touchedOpponents++;
                }
                playground[playerRow][playerCol] = "B";
                moves++;
            }


            if(touchedOpponents == opponentsCount) {
                break;
            }

            command = scanner.nextLine();
        }

        System.out.println("Game over!");
        System.out.printf("Touched opponents: %d Moves made: %d", touchedOpponents, moves);
    }

    public static boolean isInBounds(int row, int col, String[][] playerGround) {
        return row >=0 && row < playerGround.length && col >= 0 && col < playerGround[row].length;
    }

    public static boolean isObstacle(int row, int col, String[][] playGround) {
        return playGround[row][col].equals("O");
    }

    public static boolean isOpponent(int row, int col, String[][] playGround) {
        return playGround[row][col].equals("P");
    }

    public static void printField(String[][] field) {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                System.out.print(field[row][col]);
            }
            System.out.println();
        }
    }
}
