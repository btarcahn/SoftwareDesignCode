package ca.mcgill.cs.swdesign.m5.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import ca.mcgill.cs.swdesign.m2.Card;

/**
 * 
 * Standard Deck with 52 cards.
 *
 */
public class Deck implements CardSource
{
	private List<Card> aCards = new ArrayList<>();

	/**
	 * Initialization is done in the constructor to reduce unnecessary object states.
	 */
	public Deck() 
	{
		shuffle();
	}
	
	/**
	 * Initialize and shuffle the deck with standard 52 cards.
	 */
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
	public Card draw()
	{
		assert aCards.size()>0;
		return aCards.remove(aCards.size()-1);
	}
	
	

	@Override
	public int size()
	{
		return aCards.size();
	}
	
	
	public CardSourceCommand getShuffleCommand() 
	{
		
		return new CardSourceCommand() 
			{
				final List<Card> aCardsCopy = new ArrayList<>();
				
				@Override
				public Optional<Card> execute() 
				{
					for (Card card:aCards) 
					{
						aCardsCopy.add(card);
					}
					shuffle();
					return Optional.empty();
				}
				
				@Override
				public void undo() 
				{
					if (aCardsCopy.size()>0)
					{
						aCards.clear();
						for (Card card:aCardsCopy) 
						{
							aCards.add(card);
						}
						aCardsCopy.clear();
					}
				}
		};
	}
	
	@Override
	public CardSource clone() 
	{
		Deck clone;
		try
		{
			clone = (Deck)super.clone();
			clone.aCards = new ArrayList<>(aCards);
			return clone;
		}
		catch (CloneNotSupportedException e)
		{
			assert false;
			return null;
		} 
		
	}
	
}