package CountRealNumbers;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> occurrences = new LinkedHashMap<>();

        for (double number : input) {
            if(!occurrences.containsKey(number)) {
                occurrences.put(number, 0);
            }

            int oldCount = occurrences.get(number);
            occurrences.put(number, oldCount + 1);
        }

        for(Double key : occurrences.keySet()) {
            System.out.printf("%.1f -> %d%n", key, occurrences.get(key));
        }
    }
}
