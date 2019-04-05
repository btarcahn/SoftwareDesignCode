package ca.mcgill.cs.swdesign.m10.after;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest
{
	private static String  childrenMovieName = "Sesame Street";
	private static String  newReleaseMovieName = "Green Book";
	private static String  regularMovieName = "Eternal Sunshine";
	private static String 	customerName = "Justin";
	
	private static Movie newReleaseMovie;
	private static Movie childrenMovie;
	private static Movie regularMovie;
	private static Customer customer;
	
	@Before
	public void setUp() throws Exception
	{
		childrenMovie = new Movie(childrenMovieName, Movie.CHILDREN);
		newReleaseMovie = new Movie(newReleaseMovieName, Movie.NEW_RELEASE);
		regularMovie = new Movie(regularMovieName, Movie.REGULAR);		
		customer = new Customer(customerName);	
	}

	
	@Test
	public void basicChildrenRental() {
	    customer.addRental(new Rental(childrenMovie, 3));
	    assertTrue(customer.statement().equals(expectedMessageFor(childrenMovieName, 1.5, 1.5, 1)));
	}
	
	@Test
	public void discountChildrensRentals() {
	    customer.addRental(new Rental(childrenMovie, 4));
	    assertTrue(customer.statement().equals(expectedMessageFor(childrenMovieName, 3.0, 3.0, 1)));
	}
	
	@Test
	public void basicNewReleaseRental() {
	    customer.addRental(new Rental(newReleaseMovie, 1));
	    assertTrue(customer.statement().equals(expectedMessageFor(newReleaseMovieName, 3.0, 3.0, 1)));
	}
	
	@Test
	public void newReleaseRentalsWithBonusFrequentRenterPoints() {
	    customer.addRental(new Rental(newReleaseMovie, 2));
	    assertTrue(customer.statement().equals(expectedMessageFor(newReleaseMovieName, 6.0, 6.0, 2)));
	}
	
	@Test
	public void basicRegularRental() {
	    customer.addRental(new Rental(regularMovie, 2));
	    assertTrue(customer.statement().equals(expectedMessageFor(regularMovieName, 2, 2, 1)));
	}
	
	@Test
	public void discountRegularRental() {
	    customer.addRental(new Rental(regularMovie, 3));
	    assertTrue(customer.statement().equals(expectedMessageFor(regularMovieName, 3.5, 3.5, 1)));
	}
	
	@Test
	public void sumVariousRentals() {
	    customer.addRental(new Rental(childrenMovie, 2));
	    customer.addRental(new Rental(regularMovie, 1));
	    customer.addRental(new Rental(newReleaseMovie, 3));
	    assertTrue(customer.statement().equals("Rental record for " + customerName + "\n\t"
	    		+ childrenMovieName + "\t1.5\n\t" + regularMovieName + "\t2.0\n\t" + newReleaseMovieName + 
	    		"\t9.0\nAmount owed is 12.5\nYou earned 4 frequent renter points"));
	}
	
	private String expectedMessageFor(String rental, double price, double total, int renterPointsEarned) {
	    return "Rental record for " + customerName + "\n\t" + rental + "\t" + price + "\nAmount owed is " + total + "\nYou earned " + renterPointsEarned + " frequent renter points";
	}

	    
	

}
