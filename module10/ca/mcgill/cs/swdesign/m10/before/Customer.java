package ca.mcgill.cs.swdesign.m10.before;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Customer {
	private String aName;
	private List<Rental> aRentals = new ArrayList<>();

	public Customer (String pName){
	    aName = pName;
	}

	public void addRental(Rental arg) {
	    aRentals.add(arg);
	}
	  
	public String getName (){
	    return aName;
	}
	
	public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Iterator<Rental> rentals = aRentals.iterator();
        String result = "Rental record for " + getName() + "\n";
        while (rentals.hasNext()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.next();

            //determine amounts for each line
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (each.getDaysRented() > 2)
                        thisAmount += (each.getDaysRented() - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += each.getDaysRented() * 3;
                    break;
                case Movie.CHILDREN:
                    thisAmount += 1.5;
                    if (each.getDaysRented() > 3)
                        thisAmount += (each.getDaysRented() - 3) * 1.5;
                    break;
	        }
	
	        // add frequent renter points
	        frequentRenterPoints ++;
	        // add bonus for a two day new release rental
	        if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
	            each.getDaysRented() > 1) frequentRenterPoints ++;
	
	        //show figures for this rental
	        result += "\t" + each.getMovie().getTitle()+ "\t" +
	            String.valueOf(thisAmount) + "\n";
	        totalAmount += thisAmount;

        }
        //add footer lines
        result +=  "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) +
             " frequent renter points";
        return result;
}


	  
}
