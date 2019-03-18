package ca.mcgill.cs.swdesign.m6.demo;

import java.util.ArrayList;
import java.util.List;

import ca.mcgill.cs.swdesign.m2.Card;
import ca.mcgill.cs.swdesign.m2.Card.Rank;
import ca.mcgill.cs.swdesign.m2.Card.Suit;
import ca.mcgill.cs.swdesign.m5.demo.CardSource;

public class MemorizingDeck extends AbstractDeck
{
	private List<Card> aDrawnCards = new ArrayList<>();
	
	
	public MemorizingDeck(List<Card> pCards)
	{
		super(pCards);
	}


	@Override
	public Card draw()
	{
		assert size()>0;
		Card cardDrawn = super.draw();
		aDrawnCards.add(cardDrawn);
		return cardDrawn;
	}
	
	@Override
	public void log()
	{
		System.out.println("Card drawn:");
		
		for(Card card:aDrawnCards)
		{
			System.out.println(card);
		}
	}
	
	public List<Card> getDrawn() {
		return new ArrayList<Card>(aDrawnCards);
	}

	@Override
	public MemorizingDeck clone() 
	{
		MemorizingDeck clone;
		clone = (MemorizingDeck)super.clone();
		clone.aDrawnCards = new ArrayList<Card>(aDrawnCards);
		return clone;		
	}

	
		
}
