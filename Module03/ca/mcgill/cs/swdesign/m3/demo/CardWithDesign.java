package ca.mcgill.cs.swdesign.m3.demo;

public class CardWithDesign extends Card {

	public enum Design{ CLASSIC, ARTISTIC, FUN}
	
	Design aStyle;

	public CardWithDesign(Rank pRank, Suit pSuit, Design aStyle) {
		super(pRank, pSuit);
		this.aStyle = aStyle;
	}
	
	public CardWithDesign(Design aStyle) {
		super();
		this.aStyle = aStyle;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((aStyle == null) ? 0 : aStyle.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		CardWithDesign other = (CardWithDesign) obj;
		if (aStyle != other.aStyle)
			return false;
		return true;
	}
	

	/**
	 * This is the driver program.
	 * @param args
	 */
	public static void main(String[] args)
	{
		
		
		Card card1 = new CardWithDesign(Card.Rank.FOUR, Card.Suit.CLUBS, CardWithDesign.Design.ARTISTIC);
		Card card2 = new CardWithDesign(Card.Rank.FOUR, Card.Suit.CLUBS, CardWithDesign.Design.CLASSIC);
		System.out.println(card1.equals(card2));
		
		Card card3 = new Card(Card.Rank.FOUR, Card.Suit.CLUBS);
		System.out.println(card1.equals(card3));
		
		System.out.println(card3.equals(card1));
		
		System.out.println(card2.equals(card3));



	}
	
}
