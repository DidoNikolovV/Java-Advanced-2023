package HandsOfCards;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> playerData = new LinkedHashMap<>();
        Map<String, Integer> playersValues = new LinkedHashMap<>();

        while(true) {
            String input = scanner.nextLine();
            if(input.equals("JOKER")) {
                break;
            }

            String[] inputParts = input.split(": ");
            String personName = inputParts[0];
            String[] cards = inputParts[1].split(", ");

            if(!playerData.containsKey(personName)) {
                playerData.put(personName, new LinkedHashSet<>());
            }

            Set<String> oldCards = playerData.get(personName);
            Collections.addAll(oldCards, cards);

            }


        for(var entry : playerData.entrySet()) {
            int value = 0;
            for (String card : entry.getValue()) {
                String powerOfCard = card.substring(0, card.length() - 1);
                String typeOfCard = card.substring(card.length() - 1);

                int power;
                if(powerOfCard.equals("J")) {
                    power = 11;
                } else if(powerOfCard.equals("Q")) {
                    power = 12;
                } else if(powerOfCard.equals("K")) {
                    power = 13;
                } else if(powerOfCard.equals("A")) {
                    power = 14;
                } else {
                    power = Integer.parseInt(powerOfCard);
                }

                int multiplier = 0;
                if(typeOfCard.equals("S")) {
                    multiplier = 4;
                } else if(typeOfCard.equals("H")) {
                    multiplier = 3;
                } else if(typeOfCard.equals("D")) {
                    multiplier = 2;
                } else if(typeOfCard.equals("C")) {
                    multiplier = 1;
                }

                value += power * multiplier;

                playersValues.put(entry.getKey(), value);
            }

            System.out.printf("%s: %d%n", entry.getKey(), value);

        }

    }
}
