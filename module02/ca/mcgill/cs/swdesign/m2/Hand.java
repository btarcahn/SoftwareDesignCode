package ca.mcgill.cs.swdesign.m2;

import sun.invoke.empty.Empty;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * A collection of cards, presumably in a player's hand.
 */
public class Hand implements Iterable<Card>, Comparable<Hand>
{
	private int aMaxCards;
	private List<Card> aCards = new ArrayList<>();
	
	/**
	 * Creates a new hand that can hold between
	 * 0 and pMaxCards inclusively.
	 * @param pMaxCards A number between 0 and 52
	 */
	public Hand(int pMaxCards)
	{
		assert pMaxCards >=0 && pMaxCards <= Card.Rank.values().length * Card.Suit.values().length;
		aMaxCards = pMaxCards;
	}
	
	/**
	 * @return True if the number of cards is the hand is the maximum permissible.
	 */
	public boolean isFull()
	{
		return aCards.size() == aMaxCards;
	}

	/**
	 * @return true if this Hand holds zero cards.
	 */
	boolean isEmpty() { return aCards.isEmpty(); }

	/**
	 * @return the number of cards this hand is currently holding.
	 */
	int size() {
		return aCards.size();
	}
	private int totalRank() {
		return aCards.stream().map(e -> e.getRank().ordinal()).reduce(0, Integer::sum);
	}
	/**
	 * @param pCard The card to add.
	 * @pre !isFull()
	 */
	public void add(Card pCard)
	{
		assert !isFull();
		aCards.add(pCard);
	}

	/**
	 *
	 * @param pCard the card to be removed.
	 * @pre !isEmpty()
	 */
	void remove(Card pCard) {
		assert !isEmpty();
		aCards.remove(pCard);
	}

	/**
	 * Checks if a given card is available in this hand.
	 * @param pCard the Card to be checked.
	 * @return true if this Hand contains the Card.
	 */
	boolean contains(Card pCard) {
		return aCards.contains(pCard);
	}

	@Override
	public Iterator<Card> iterator()
	{
		return aCards.iterator();
	}

	@Override
	public int compareTo(Hand o) {
		return size() - o.size();
	}

	/*
	* Below is the Comparators provided
	* */
	static Comparator<Hand> bySizeAscendingComparator = new Comparator<Hand>() {
		@Override
		public int compare(Hand o1, Hand o2) {
			return o1.size() - o2.size();
		}
	};
	static Comparator<Hand> bySizeDescendingComparator = bySizeAscendingComparator.reversed();
	static Comparator<Hand> byTotalRankAscendingComparator = new Comparator<Hand>() {
		@Override
		public int compare(Hand o1, Hand o2) {
			return o1.totalRank() - o2.totalRank();
		}
	};
	static Comparator<Hand> byTotalRankDescendingComparator = byTotalRankAscendingComparator.reversed();

	@Override
	public String toString() {
		return "Hand{" +
				"aCards=" + aCards +
				'}';
	}
}
