package ca.mcgill.cs.swdesign.m3.demo;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *   
 *  This version of Deck has the following states:
 *  shuttled and complete,
 *  incomplete,
 *  empty
 *    
 *  
 *  This is a demonstration of class that finishes initialization 
 *  in the constructor to remove invalid states, and with no useless states

 *  
 */
public class Deck2
{
	private final List<Card> aCards;
	
	public Deck2()
	{
		aCards = new ArrayList<>();
		shuffle();
	}
	
	
	public Collection<Card> getCards()
	{
		return Collections.unmodifiableCollection(aCards);
	}
	
	
	public boolean isEmpty()
	{
		return aCards.isEmpty();
	}
	
	public Card draw()
	{
		assert aCards.size()>0;
		return aCards.remove(aCards.size()-1);
	}
	
	public void shuffle()
	{
		aCards.clear();
		for(Card.Suit suit : Card.Suit.values() )
		{
			for( Card.Rank rank : Card.Rank.values())
			{
				aCards.add(new Card(rank, suit));
			}
		}
		Collections.shuffle(aCards);
	}
	
	@Override
	public String toString()
	{
		StringWriter writer = new StringWriter();
		for( Card card : aCards )
		{
			writer.append(card.toString() + "\n");
		}
		return writer.toString();
	}

	
	/**
	 * This is the driver program.
	 * @param args
	 */
	public static void main(String[] args)
	{

		Deck2 deck = new Deck2();
		Card cardFromDeck = deck.draw();
		System.out.println(cardFromDeck.toString());
		

	}
}
