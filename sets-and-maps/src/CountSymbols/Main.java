package CountSymbols;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> charOccurrences = new TreeMap<>();

        String text = scanner.nextLine();

        for (int i = 0; i < text.length(); i++) {
            String currentChar = String.valueOf(text.charAt(i));
            if(!charOccurrences.containsKey(currentChar)) {
                charOccurrences.put(currentChar, 0);
            }

            int oldOccurrences = charOccurrences.get(currentChar);
            charOccurrences.put(currentChar, oldOccurrences + 1);
        }

        for(var entry : charOccurrences.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " time/s");
        }
    }
}
