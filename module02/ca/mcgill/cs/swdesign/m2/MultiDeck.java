package ca.mcgill.cs.swdesign.m2;

import java.util.List;

class MultiDeck {
    private List<Deck> aDecks;

    public List<Deck> getDecks() {
        return aDecks;
    }

    public void setDecks(List <Deck> pDecks) {
        aDecks = pDecks;
    }

    /**
     * Constructs a shallow copy of class MultiDeck.
     * @param pMultiDeck the MultiDeck object to be copied.
     */
    MultiDeck(MultiDeck pMultiDeck) {
        aDecks = pMultiDeck.getDecks();
    }
}
