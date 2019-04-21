package ca.mcgill.cs.swdesign.m1;

public enum Card {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN,
    JACK, QUEEN, KING;
    public enum Suit {
        HEART, SPADE, CLUB, DIAMOND;
        public Suit getSuit(int order) {
            return Suit.values()[order];
        }
    }
    public Card getCard(int order) {
        return Card.values()[order];
    }
}
