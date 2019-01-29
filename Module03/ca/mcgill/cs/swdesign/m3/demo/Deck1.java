package ca.mcgill.cs.swdesign.m3.demo;


import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/** 
 *   
 *  This version of Deck has the following states:
 *  empty, initialized, 
 *  ordered and complete, shuttled and complete,
 *  ordered and incomplete, shuttled and incomplete. 
 *  
 *  Within the ordered state, you can further decompose it into 
 *  ordered by suit and ordered by rank.
 *  
 *  This is a demonstration of class with many states that 
 *  might be invalid and useless, and therefore error prone.
 *  
 */
public class Deck1
{
	private final List<Card> aCards;
	
	public Deck1() 
	{
		aCards = new  ArrayList<>();
	}
	
	public void initilize() {
		aCards.clear();
		for(Card.Suit suit : Card.Suit.values() )
		{
			for( Card.Rank rank : Card.Rank.values())
			{
				aCards.add(new Card(rank, suit));
			}
		}
	}
	
	public void shuffle()
	{
		Collections.shuffle(aCards);
	}
	
	
	public void sortBySuit()
	{
		Collections.sort(aCards, (o1,o2) ->
			o1.getSuit().compareTo(o2.getSuit())
			);
	}
	
	public void sortByRank()
	{
		Collections.sort(aCards, (o1,o2) ->
			o1.getRank().compareTo(o2.getRank())
			);
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

		Deck1 deck = new Deck1();
		deck.initilize();
		deck.shuffle();
		Card cardFromDeck = deck.draw();
		System.out.println(cardFromDeck.toString());
		

	}
}
