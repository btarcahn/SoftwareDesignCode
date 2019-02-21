package ca.mcgill.cs.swdesign.m5.demo;

import java.util.ArrayList;
import java.util.List;

import ca.mcgill.cs.swdesign.m2.Card;

/**
 * Composite that enables primitives to have CardSource as children.
 */
public class CompositeCardSource implements CardSource 
{
	private List<CardSource> aElements = new ArrayList<>();

	@Override
	public Card draw()
	{
		assert size()>0;
		for(CardSource source : aElements) 
		{
			if (source.size()>0)
			{
				return source.draw();
			}
		}
		assert false;
		return null;
	}

	@Override
	public int size()
	{
		int total = 0;
		for(CardSource source : aElements) 
		{
			total += source.size();
		}
		return total;
	}
	
	/**
	 * Add children to the CardSource composite.
	 * @param pCardSource 
	 */
	public void add(CardSource pCardSource) 
	{
		if(!aElements.contains(pCardSource))
			aElements.add(pCardSource);
	}
	
	@Override
	public CardSource clone() 
	{
		CompositeCardSource clone;
		try
		{
			clone = (CompositeCardSource)super.clone();
			clone.aElements = new ArrayList<>();
			for (CardSource cs:aElements) 
			{
				clone.aElements.add(cs.clone());
			}
			return clone;
		}
		catch (CloneNotSupportedException e)
		{
			assert false;
			return null;
		} 
		
	}
}
