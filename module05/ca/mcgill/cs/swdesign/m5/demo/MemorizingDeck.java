package ca.mcgill.cs.swdesign.m5.demo;

import java.util.ArrayList;
import java.util.List;

import ca.mcgill.cs.swdesign.m2.Card;

/**
 * Specialized class solution for attaching additional responsibility of 
 * memorizing card drawn to CardSource.
 *
 */
public class MemorizingDeck implements CardSource
{
	private final List<Card> aCards;
	private final List<Card> aDrawnCards = new ArrayList<>();

	/** 
	 * @param pCards Card sequence to initialize the deck
	 */
	public MemorizingDeck(List<Card> pCards) 
	{
		aCards = new ArrayList<Card>(pCards);
	}
	@Override
	public Card draw()
	{
		assert size()>0;
		Card cardDrawn = aCards.get(aCards.size()-1);
		aCards.remove(aCards.size()-1);
		aDrawnCards.add(cardDrawn);
		return cardDrawn;
	}

	@Override
	public int size()
	{
		return aCards.size();
	}

}
