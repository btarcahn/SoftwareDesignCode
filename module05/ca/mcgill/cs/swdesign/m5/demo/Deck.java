package ca.mcgill.cs.swdesign.m5.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ca.mcgill.cs.swdesign.m2.Card;

public class Deck implements CardSource
{
	private List<Card> aCards;

	public Deck() 
	{
		aCards = new  ArrayList<>();
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
	
}