package ca.mcgill.cs.swdesign.m5.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ca.mcgill.cs.swdesign.m2.Card;

/**
 * Enable attaching additional responsibility of 
 * memorizing card drawn to CardSource dynamically.
 */
public class MemorizingDecorator implements CardSource
{
	private CardSource aCardSource;
	private List<Card> aDrawnCards = new ArrayList<>(); 

	/**
	 * @param pCardSource the decorated card source.
	 */
	public MemorizingDecorator(CardSource pCardSource) 
	{
		aCardSource = pCardSource;
	}
	@Override
	public Card draw()
	{
		assert size()>0;
		Card cardDrawn = aCardSource.draw();
		aDrawnCards.add(cardDrawn);
		return cardDrawn;
	}

	@Override
	public int size()
	{
		return aCardSource.size();
	}

	@Override
	public CardSource clone() 
	{
		MemorizingDecorator clone;
		try
		{
			clone = (MemorizingDecorator)super.clone();
			clone.aCardSource = aCardSource.clone();
			clone.aDrawnCards = new ArrayList<Card>(aDrawnCards);
			return clone;
		}
		catch (CloneNotSupportedException e)
		{
			assert false;
			return null;
		} 
		
	}
	
	public Iterator<Card> getDrawnCards()
	{
		return aDrawnCards.iterator();
	}
	
	
}
