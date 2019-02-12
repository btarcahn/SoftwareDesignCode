package ca.mcgill.cs.swdesign.m5.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ca.mcgill.cs.swdesign.m2.Card;

public class CardSequence implements CardSource
{
	private final List<Card> aCards;
	
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


}
