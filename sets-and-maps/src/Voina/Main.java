package Voina;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> deckOne = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));
        Set<Integer> deckTwo = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        int round = 1;

        while(!deckOne.isEmpty() && !deckTwo.isEmpty()) {
            if(round >= 50) {
                break;
            }
            int deckOneCard = deckOne.iterator().next();
            deckOne.remove(deckOneCard);
            int deckTwoCard = deckTwo.iterator().next();
            deckTwo.remove(deckTwoCard);

            if(deckOneCard > deckTwoCard) {
                deckOne.add(deckOneCard);
                deckOne.add(deckTwoCard);
            } else if(deckTwoCard > deckOneCard){
                deckTwo.add(deckOneCard);
                deckTwo.add(deckTwoCard);
            }
            round++;
        }

        if (deckOne.size() < deckTwo.size()) {
            System.out.println("Second player win!");
        } else if (deckTwo.size() < deckOne.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Draw!");
        }

    }
}
