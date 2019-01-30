package ca.mcgill.cs.swdesign.m3.demo;

import java.util.Optional;


public class Card
{
	public enum Rank 
	{ ACE, TWO, THREE, FOUR, FIVE, SIX,
		SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
		
		@Override
		public String toString()
		{
			return name().substring(0, 1) + name().substring(1).toLowerCase();
		}
	}
	
	/**
	 * A card's suit.
	 */
	public enum Suit
	{
		CLUBS, DIAMONDS, SPADES, HEARTS
	}
	
	private final Optional<Rank> aRank;
	private final Optional<Suit> aSuit;
	private boolean aIsJoker;
	
	/**
	 * @param pRank The index of the rank in RANKS
	 * @param pSuit The index of the suit in SUITS
	 * @pre pRank != null &amp;&amp; pSuit != null
	 */
	public Card(Rank pRank, Suit pSuit)
	{
		assert pRank != null && pSuit != null;
		aRank =  Optional.of(pRank);
		aSuit = Optional.of(pSuit);
	}
	
	public Card() 
	{
		aIsJoker = true;
		aRank = Optional.empty();
		aSuit = Optional.empty();
	}
	
	public boolean isJoker() 
	{
		return aIsJoker;
	}
	
	
	
	/**
	 * @return The index in RANKS corresponding to the rank of the card.
	 * @pre !isJoker()
]	 */
	public Rank getRank()
	{
		assert !isJoker();
		return aRank.get();
	}
	
	/**
	 * @return The index in SUITS corresponding to the suit of the card.
	 */
	public Suit getSuit()
	{
		assert !isJoker();
		return aSuit.get();
	}
	
	
	@Override
	public String toString()
	{
		if (isJoker())
			return "Joker";
		else
			return getRank() + " of " + getSuit();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (aIsJoker ? 1231 : 1237);
		result = prime * result + aRank.hashCode();
		result = prime * result + aSuit.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (aIsJoker != other.aIsJoker)
			return false;
		if (aRank == null) {
			if (other.aRank != null)
				return false;
		} else if (!aRank.equals(other.aRank))
			return false;
		if (aSuit == null) {
			if (other.aSuit != null)
				return false;
		} else if (!aSuit.equals(other.aSuit))
			return false;
		return true;
	}

	/**
	 * This is the driver program.
	 * @param args
	 */
	public static void main(String[] args)
	{
		Card joker = new Card();
//		joker1.getRank(); // Run-time Exception
		
		Card card1 = new Card(Card.Rank.FOUR, Card.Suit.CLUBS);
		Card card2 = new Card(Card.Rank.FOUR, Card.Suit.CLUBS);
		System.out.println(card1.equals(card2));

					

	}
}
