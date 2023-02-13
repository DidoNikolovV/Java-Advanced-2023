package Exam_13_April;

import java.util.*;

public class Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> steel = new ArrayDeque<>();
        ArrayDeque<String> carbon = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                        .forEach(steel::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .forEach(carbon::push);

        Map<String, Integer> swordsData = new HashMap<>();
        swordsData.put("Gladius", 70);
        swordsData.put("Shamshir", 80);
        swordsData.put("Katana", 90);
        swordsData.put("Sabre", 110);

        Map<String, Integer> swordsCrafted = new TreeMap<>();

        int totalSwordsCrafted = 0;

        while(steel.size() > 0 && carbon.size() > 0) {
            int currentSteel = Integer.parseInt(steel.poll());
            int currentCarbon =  Integer.parseInt(carbon.pop());

            boolean crafted = false;

            for (var entry: swordsData.entrySet()) {
                String currentSword = entry.getKey();
                int resourcesNeeded = entry.getValue();
                if(currentSteel + currentCarbon == resourcesNeeded) {
                    crafted = true;
                    totalSwordsCrafted++;
                    craftSword(swordsCrafted, currentSword);
                }
            }

            if(!crafted) {
                currentCarbon += 5;
                carbon.push(String.valueOf(currentCarbon));
            }

        }

        if(swordsCrafted.size() >= 1) {
            System.out.printf("You have forged %d swords.%n", totalSwordsCrafted);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        if(steel.size() > 0) {
            System.out.print("Steel left: ");
            System.out.println(String.join(", ", steel));
        } else {
            System.out.println("Steel left: none");
        }

        if(carbon.size() > 0) {
            System.out.print("Carbon left: ");
            System.out.println(String.join(", ", carbon));
        } else {
            System.out.println("Carbon left: none");
        }

        for (var entry : swordsCrafted.entrySet()) {
            String sword = entry.getKey();
            int quantity = entry.getValue();
            System.out.printf("%s: %d%n", sword, quantity);
        }

    }

    public static void craftSword(Map<String, Integer> craftedSwords, String sword) {
        if(!craftedSwords.containsKey(sword)) {
            craftedSwords.put(sword, 0);
        }

        int oldValue = craftedSwords.get(sword);
        craftedSwords.put(sword, oldValue + 1);
    }
}
