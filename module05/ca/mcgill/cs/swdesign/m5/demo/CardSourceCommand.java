package ca.mcgill.cs.swdesign.m5.demo;

import java.util.Optional;

import ca.mcgill.cs.swdesign.m2.Card;

/**
 * 
 * Achieve function object management through Command pattern.
 *
 */
public interface CardSourceCommand
{
	/**
	 * 
	 * @return 	the production of the execution if it's a card, 
	 * 			empty if the execute doesn't produce output.
	 */
	Optional<Card> execute();
	
	/**
	 * Undo the immediate previous execution.
	 */
	void undo();

}
