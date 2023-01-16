package CompareMatrices;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstCoordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[][] firstArray = new int[firstCoordinates[0]][firstCoordinates[1]];

        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[] secondCoordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[][] secondArray = new int[secondCoordinates[0]][secondCoordinates[1]];

        for (int i = 0; i < secondArray.length; i++) {
            secondArray[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        if((firstArray[0].length != secondArray[0].length) || (firstArray.length != secondArray.length)) {
            System.out.println("not equal");
            return;
        }


        boolean areEqual = true;
        for (int row = 0; row < firstArray.length; row++) {
            for (int col = 0; col < firstArray[row].length; col++) {
                if(firstArray[row][col] != secondArray[row][col]) {
                    areEqual = false;
                    break;
                }
            }

            if(!areEqual) {
                break;
            }
        }

        if(!areEqual) {
            System.out.println("not equal");
        } else {
            System.out.println("equal");
        }



    }
}
