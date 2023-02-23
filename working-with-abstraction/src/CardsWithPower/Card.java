package CardsWithPower;

public class Card {

    private int power;
    public Card(RankPower rp, SuitPower sp) {
        this.power = rp.getPower() + sp.getPower();
    }

    public int getPower() {
        return power;
    }
}
