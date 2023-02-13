package Exam_25_June;

import java.util.*;

public class ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Double> milkValues = new ArrayDeque<>();
        ArrayDeque<Double> cocoaValues = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s"))
                .mapToDouble(Double::parseDouble)
                        .forEach(milkValues::offer);

        Arrays.stream(scanner.nextLine().split("\\s"))
                .mapToDouble(Double::parseDouble)
                .forEach(cocoaValues::push);

        Map<String, Integer> chocolateData = new HashMap<>();
        chocolateData.put("Milk Chocolate", 30);
        chocolateData.put("Dark Chocolate", 50);
        chocolateData.put("Baking Chocolate", 100);

        double cocoaPowderPercent;

        Map<String, Integer> prepared = new TreeMap<>();


        while(milkValues.size() > 0 && cocoaValues.size() > 0) {
            double milkValue = milkValues.poll();
            double cocoaValue = cocoaValues.pop();

            boolean made = false;

            cocoaPowderPercent = cocoaValue / (milkValue + cocoaValue) * 100;

            for(var entry: chocolateData.entrySet()) {
                String currentChocoType = entry.getKey();
                int currentChocoCocoa = entry.getValue();
                if(cocoaPowderPercent == currentChocoCocoa) {
                    if(currentChocoType.equals("Milk Chocolate")) {
                        prepareChocolate(prepared, currentChocoType);
                    } else if(currentChocoType.equals("Dark Chocolate")) {
                        prepareChocolate(prepared, currentChocoType);
                    } else if(currentChocoType.equals("Baking Chocolate")) {
                        prepareChocolate(prepared, currentChocoType);
                    }
                    made = true;
                    break;
                }
            }

            if(!made) {
                milkValue+= 10;
                milkValues.offer(milkValue);
            }
        }

        if(prepared.size() >= 3) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        for(var entry: prepared.entrySet()) {
            System.out.printf("# %s --> %d%n", entry.getKey(), entry.getValue());
        }
    }

    public static void prepareChocolate(Map<String, Integer> prepared, String chocolate) {
        if(!prepared.containsKey(chocolate)) {
            prepared.put(chocolate, 0);
        }

        int oldValue = prepared.get(chocolate);
        prepared.put(chocolate, oldValue + 1);
    }
}
