package SetsOfElements;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] setsLength = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int setOneLength = setsLength[0];
        int setTwoLength = setsLength[1];

        int sumOfLengths = setOneLength + setTwoLength;

        Set<Integer> setOne = new LinkedHashSet<>();
        Set<Integer> setTwo = new LinkedHashSet<>();
        List<String> filtered = new ArrayList<>();

        for (int i = 0; i < setOneLength; i++) {
            setOne.add(Integer.parseInt(scanner.nextLine()));
        }

        for (int i = 0; i < setTwoLength; i++) {
            setTwo.add(Integer.parseInt(scanner.nextLine()));
        }

        if(setOneLength > setTwoLength) {
            for(int num : setOne) {
                if(setTwo.contains(num)) {
                    filtered.add(String.valueOf(num));
                }
            }
        } else {
            for(int num : setTwo) {
                if(setOne.contains(num)) {
                    filtered.add(String.valueOf(num));
                }
            }
        }

        String result = String.join(" ", filtered);
        System.out.println(result);
    }
}
