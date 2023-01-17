package MatrixOfPalindromes;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] size = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = size[0];
        int cols = size[1];
        String[][] matrix = new String[rows][cols];

        String text = "";
        int initialAscii = 97;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                String firstLetter = String.valueOf((char) (initialAscii + row));
                String secondLetter =  String.valueOf((char) (initialAscii + col + row));
                String thirdLetter =  String.valueOf((char) (initialAscii + row));
                text = firstLetter + secondLetter + thirdLetter;
                matrix[row][col] = text;
            }
        }

        for(String[] arr : matrix) {
            for(String element : arr) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
}
