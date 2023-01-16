package IntersectionOfTwoMatrices;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = new char[rows][cols];
        char[][] secondMatrix = new char[rows][cols];

        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                char character = scanner.next().charAt(0);
                firstMatrix[row][col] = character;
            }
        }

        for (int row = 0; row < secondMatrix.length; row++) {
            for (int col = 0; col < secondMatrix[row].length; col++) {
                char character = scanner.next().charAt(0);
                secondMatrix[row][col] = character;
            }
        }

        char[][] resultMatrix = new char[rows][cols];

        for (int row = 0; row < secondMatrix.length; row++) {
            for (int col = 0; col < secondMatrix[row].length; col++) {
                if(firstMatrix[row][col] == secondMatrix[row][col]) {
                    resultMatrix[row][col] = firstMatrix[row][col];
                } else {
                    resultMatrix[row][col] = '*';
                }
            }
        }

        for (char[] row: resultMatrix) {
            for(char ch: row) {
                System.out.print(ch + " ");
            }

            System.out.println();
        }
    }
}
