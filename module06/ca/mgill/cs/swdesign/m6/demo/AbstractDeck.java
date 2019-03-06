package ca.mgill.cs.swdesign.m6.demo;

import ca.mcgill.cs.swdesign.m2.Card;
import ca.mcgill.cs.swdesign.m5.demo.CardSource;
import ca.mcgill.cs.swdesign.m5.demo.MemorizingDecorator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDeck implements CardSource
{
	protected  List<Card> aCards;

	protected AbstractDeck(List<Card> pCards) 
	{
		assert pCards!=null;
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
	
	public abstract void log();
	
	@Override
	public AbstractDeck clone() 
	{
		AbstractDeck clone;
		try
		{
			clone = (AbstractDeck)super.clone();
			clone.aCards = new ArrayList<Card>(aCards);
			return clone;
		}
		catch (CloneNotSupportedException e)
		{
			assert false;
			return null;
		} 
		
	}
	
}
