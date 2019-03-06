package ca.mgill.cs.swdesign.m6.demo;

import java.util.ArrayList;
import java.util.List;

import ca.mcgill.cs.swdesign.m2.Card;
import ca.mcgill.cs.swdesign.m2.Card.Rank;
import ca.mcgill.cs.swdesign.m2.Card.Suit;
import ca.mcgill.cs.swdesign.m5.demo.CardSource;

public class Client
{
	/**
	 * @param pArgs Not used here
	 */
	public static void main(String[] pArgs)
	{
			
		List<Card> fourAces = new ArrayList<Card>();
		fourAces.add(new Card(Rank.ACE, Suit.CLUBS));
		fourAces.add(new Card(Rank.ACE, Suit.DIAMONDS));
		fourAces.add(new Card(Rank.ACE, Suit.HEARTS));
		fourAces.add(new Card(Rank.ACE, Suit.SPADES));
		
		CardSource deck3 = new MemorizingDeck(fourAces);
		deck3.draw();
		deck3.draw();
		((MemorizingDeck)deck3).log();
		
		
		CardSource deck3Clone = deck3.clone();
		((MemorizingDeck)deck3Clone).log();
		
		int sizesLimit = 10;
		CardSource deck4 = new RefillDeck(fourAces, sizesLimit);
		deck4.draw();
		((RefillDeck) deck4).refill();
		
		((RefillDeck) deck4).log();
		
	}
}
