package GenericSwapMethod;

import java.util.*;

public class Main<T> {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> myList = new CustomList<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();
            myList.add(text);
        }

        int[] indices = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .mapToInt(Integer::parseInt).toArray();

        int index1 = indices[0];
        int index2 = indices[1];

        myList.swap(index1, index2);

        String result = myList.toString();
        System.out.println(result);

    }

}
