package ca.mcgill.cs.swdesign.m2;

public class Game
{
	private static final int MAX_CARDS = 10;
	private static final int STARTING_CARDS = 5;
	private Deck aDeck = new Deck();
	private Hand aPlayer1 = new Hand(MAX_CARDS);
	private Hand aPLayer2 = new Hand(MAX_CARDS);
	public Game()
	{
		aDeck.shuffle();
		System.out.println(aDeck);
//		aDeck.sortByRank();
//		System.out.println(aDeck);
		try {
			play();
		} catch (EmptyDeckException e) {
			e.printStackTrace();
		}
		System.out.println(aPlayer1);
		System.out.println(aPLayer2);
		System.out.println(aPlayer1.byTotalRankAscendingComparator
				.thenComparing(aPlayer1.bySizeAscendingComparator)
				.compare(aPlayer1, aPLayer2));
	}

	private void play() throws EmptyDeckException {
		aDeck.shuffle();
		for (int i = 0; i < STARTING_CARDS; i++) {
			aPlayer1.add(aDeck.draw());
			aPLayer2.add(aDeck.draw());
		}
	}
	
	public static void main(String[] args)
	{
		new Game();
	}
}
