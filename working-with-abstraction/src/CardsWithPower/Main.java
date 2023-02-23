package CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String cardRank = scanner.nextLine();
        String cardSuit = scanner.nextLine();


        RankPower rp = RankPower.valueOf(cardRank);
        SuitPower sp = SuitPower.valueOf(cardSuit);
        Card card = new Card(rp, sp);

        System.out.printf("Card name: %s of %s; Card power: %d",
                cardRank, cardSuit, card.getPower());

    }
}
