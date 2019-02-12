package ca.mcgill.cs.swdesign.m5.demo;

import ca.mcgill.cs.swdesign.m2.Card;

/**
 * Primitive for representing card sources.
 */
public interface CardSource
{
	/**
	 * Remove a card from the source and return it.
	 * 
	 * @return The card that was removed from the source
	 * @pre size()>0	 
	 */
	Card draw();
	
	/**
	 * @return The number of cards in the source.
	 */
	int size();
	
}

