package ca.mcgill.cs.swdesign.m5.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Aggregate a collection of card sources.
 * The client can get existing card sources or add new card sources 
 * through polymophic object cloning.
 * 
 */
public class CardSourceManager
{
	private final List<CardSource> aCardSources = new ArrayList<>();
	private CardSource aPrototype = new Deck();

	/**
	 * 
	 * @return the existing card sources .
	 */
	public List<CardSource> getCardSources() 
	{
		// return a copy of aCardSources;
		List<CardSource> cardSources = new ArrayList<>();
		for(CardSource cs:aCardSources)
		{
			cardSources.add(cs.clone());
		}
		return cardSources;
	}
	

	public void addCardSource() 
	{
		aCardSources.add(aPrototype.clone());
	}
	
	public void setPrototype(CardSource pCardSource)
	{
		aPrototype = pCardSource.clone();
	}
}
