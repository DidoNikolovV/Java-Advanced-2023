package GenericSwapMethod;

import java.util.*;

public class Main<T> {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<Double> myList = new CustomList<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            Double input = Double.parseDouble(scanner.nextLine());
            myList.add(input);
        }

        Double elementToCompare = Double.parseDouble(scanner.nextLine());

        int result = myList.getGreaterElementsCount(elementToCompare);

        System.out.println(result);

    }

}
