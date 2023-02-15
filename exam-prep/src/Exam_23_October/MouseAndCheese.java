package Exam_23_October;

import java.util.Scanner;

public class MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] territory = new char[size][size];

        int mouseRow = -1;
        int mouseCol = -1;
        int cheeseRow = -1;
        int cheeseCol = -1;

        for (int row = 0; row < size; row++) {
            territory[row] = scanner.nextLine().toCharArray();
            for (int col = 0; col < size; col++) {
                if(territory[row][col] == 'M') {
                    mouseRow = row;
                    mouseCol = col;
                }
            }
        }

        String command = scanner.nextLine();

        int cheeseEaten = 0;
        boolean isMouseLost = false;
        while(!command.equals("end")) {

            territory[mouseRow][mouseCol] = '-';
            if(command.equals("up") && mouseRow != 0) {
                mouseRow--;
            } else if(command.equals("down") && mouseRow != size - 1) {
                mouseRow++;
            } else if(command.equals("right") && mouseCol != size - 1) {
                mouseCol++;
            } else if(command.equals("left") && mouseCol != 0) {
                mouseCol--;
            } else {
                System.out.println("Where is the mouse?");
                break;
            }

            if(territory[mouseRow][mouseCol] == 'B') {
                territory[mouseRow][mouseCol] = 'M';
                continue;
            }

            if(territory[mouseRow][mouseCol] == 'c') {
                cheeseEaten++;
            }
            territory[mouseRow][mouseCol] = 'M';



            command = scanner.nextLine();
        }



        if(cheeseEaten < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheeseEaten);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheeseEaten);
        }

        printTerritory(territory);
    }

    public static void printTerritory(char[][] territory) {
        for (int row = 0; row < territory.length; row++) {
            for (int col = 0; col < territory[row].length; col++) {
                System.out.print(territory[row][col] + "");
            }
            System.out.println();
        }
    }
}
