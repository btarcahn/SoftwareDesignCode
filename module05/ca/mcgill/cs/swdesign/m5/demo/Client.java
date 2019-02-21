package ca.mcgill.cs.swdesign.m5.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ca.mcgill.cs.swdesign.m2.Card;
import ca.mcgill.cs.swdesign.m2.Card.Rank;
import ca.mcgill.cs.swdesign.m2.Card.Suit;

public final class Client
{ 
	private Client()
	{}
	
	/**
	 * @param pArgs Not used here
	 */
	public static void main(String[] pArgs)
	{
		
		Deck deck = new Deck();
		deck.draw();
		CardSource deckClone = deck.clone();
		System.out.println(deck.size() == deckClone.size());
		
		CardSourceCommand command = deck.getShuffleCommand();
		command.execute();
		System.out.println("Command executed.");
		System.out.println(deck.size());
		
		command.undo();
		System.out.println("Undo command.");
		System.out.println(deck.size());

		
		List<Card> fourAces = new ArrayList<Card>();
		fourAces.add(new Card(Rank.ACE, Suit.CLUBS));
		fourAces.add(new Card(Rank.ACE, Suit.DIAMONDS));
		fourAces.add(new Card(Rank.ACE, Suit.HEARTS));
		fourAces.add(new Card(Rank.ACE, Suit.SPADES));


		CardSource fourAcesDeck = new CardSequence(fourAces);
		CompositeCardSource compositeDeck = new CompositeCardSource();
		compositeDeck.add(fourAcesDeck);
		compositeDeck.add(new Deck());


		CardSource memorizingDeck = new MemorizingDecorator(compositeDeck);
		
		Card card1 = memorizingDeck.draw();
		Card card2 = memorizingDeck.draw();

		System.out.println("Card drawn:");
		System.out.println(card1);
		System.out.println(card2);
		
		System.out.println("Card memorized:");
		for (Iterator<Card> it = ((MemorizingDecorator) memorizingDeck).getDrawnCards();it.hasNext();) 
		{
			System.out.println(it.next());

		}
		
		CardSourceManager manager = new CardSourceManager();
		manager.setPrototype(new DrawTwoDecorator(new Deck()));
		manager.addCardSource();
		
		manager.setPrototype(memorizingDeck);
		manager.addCardSource();
		
		for(CardSource source:manager.getCardSources())
		{
			System.out.println(source.draw());
			System.out.println(source.size());
		}
		
	}

	
	
	
	
	
	
	
	
	
	
	

}
