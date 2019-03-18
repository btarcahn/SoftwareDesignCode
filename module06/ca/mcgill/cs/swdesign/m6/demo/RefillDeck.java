package ca.mcgill.cs.swdesign.m6.demo;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ca.mcgill.cs.swdesign.m2.Card;
import ca.mcgill.cs.swdesign.m2.Card.Rank;
import ca.mcgill.cs.swdesign.m2.Card.Suit;

public class RefillDeck extends AbstractDeck
{
	private final int aRefillSize;
	private static final Random RANDOM = new Random();
	private List<Card> aRefillHistory = new ArrayList<>();

	protected RefillDeck(List<Card> pCard, int pRefillSize)
	{
		super(pCard);
		assert pRefillSize>0;
		aRefillSize = pRefillSize;
		
	}

	public void refill() 
	{
		List<Card> refilledCard = new ArrayList<>();
		while(aCards.size()<aRefillSize) {
			int rankIndex = RANDOM.nextInt(Rank.values().length);
			int suitIndex = RANDOM.nextInt(Suit.values().length);		
			Card card = new Card(Rank.values()[rankIndex], Suit.values()[suitIndex]);
			if(refilledCard.contains(card))
				continue;
			aCards.add(card);
			refilledCard.add(card);
		}
		aRefillHistory.addAll(refilledCard);
	}
	
	@Override
	public void log()
	{
		System.out.println("Card refilled to the deck:");
		
		for(Card card:aRefillHistory)
		{
			System.out.println(card);
		}

	}
	
	@Override
	public RefillDeck clone() 
	{
		RefillDeck clone;
		clone = (RefillDeck)super.clone();
		clone.aRefillHistory = new ArrayList<Card>(aRefillHistory);
		return clone;		
	}

}
