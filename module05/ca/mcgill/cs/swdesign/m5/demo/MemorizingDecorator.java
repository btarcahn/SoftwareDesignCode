package ca.mcgill.cs.swdesign.m5.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ca.mcgill.cs.swdesign.m2.Card;

/**
 * Enable attaching additional responsibility of 
 * memorizing card drawn to CardSource dynamically.
 */
public class MemorizingDecorator implements CardSource, Iterable<Card>
{
	private final CardSource aCardSource;
	private final List<Card> aDrawnCards = new ArrayList<>(); 

	
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
	public Iterator<Card> iterator()
	{
		return aDrawnCards.iterator();
	}

}
