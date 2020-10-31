package CardsWithPower;

public class Card {
    private int power;
    private String rank;
    private String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
        this.power = RankPowers.valueOf(rank).getPower() + SuitPowers.valueOf(suit).getPower();
    }

    @Override
    public String toString(){
        return String.format("Card name: %s of %s; Card power: %d", this.rank, this.suit, this.power);
    }
}
