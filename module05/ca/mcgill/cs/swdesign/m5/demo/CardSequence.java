package ca.mcgill.cs.swdesign.m5.demo;

import java.util.ArrayList;
import java.util.List;

import ca.mcgill.cs.swdesign.m2.Card;
import ca.mcgill.cs.swdesign.m2.Card.Rank;
import ca.mcgill.cs.swdesign.m2.Card.Suit;

/**
 * 
 * A customized a deck. Initialization of the deck is done 
 * by calling the constructor with input card sequence. 
 *
 */
public class CardSequence implements CardSource
{
	private List<Card> aCards;
	
	/** 
	 * @param pCards Card sequence to initialize the deck
	 */
	public CardSequence(List<Card> pCards) 
	{
		aCards = new ArrayList<>(pCards);
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
	
	@Override
	public CardSource clone() {
		CardSequence clone;
		try
		{
			clone = (CardSequence)super.clone();
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
