package ca.mcgill.cs.swdesign.m1;

import java.util.ArrayList;
import java.util.List;

class MultiDeck {
    private List<Deck> aDecks;

    public List<Deck> getDecks() {
        return aDecks;
    }

    public void setDecks(List<Deck> pDecks) {
        aDecks = pDecks;
    }

    /**
     * Constructs a deep copy of class MultiDeck.
     * @param pMultiDeck the MultiDeck object to be copied.
     */
    MultiDeck(MultiDeck pMultiDeck) {
        aDecks = new ArrayList<>();
        pMultiDeck.getDecks().forEach(deck -> aDecks.add(new Deck(deck)));
        assert !isSameCopy(pMultiDeck);
    }

    private static boolean isSameDeckCopy(Deck pDeck1, Deck pDeck2) {
        return pDeck1 == pDeck2;
    }

    private boolean isSameCopy(MultiDeck pMultiDeck) {
        if (aDecks == pMultiDeck.getDecks()) { return true; }
        for (Deck deck : aDecks) {
            for (Deck pDeck : pMultiDeck.getDecks()) {
                if (isSameDeckCopy(deck, pDeck)) { return true; }
            }
        }
        return false;
    }
}
