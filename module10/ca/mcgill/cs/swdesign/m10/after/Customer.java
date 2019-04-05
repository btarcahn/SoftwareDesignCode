package ca.mcgill.cs.swdesign.m10.after;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Customer {
	private String aName;
	private List<Rental> aRentals = new ArrayList<>();

	public Customer (String pName){
	    aName = pName;
	}

	public void addRental(Rental pRental) {
	    aRentals.add(pRental);
	}
	  
	public String getName (){
	    return aName;
	}
	
	public String statement() {
        Iterator<Rental> rentals = aRentals.iterator();
        String result = "Rental record for " + getName() + "\n";
        while (rentals.hasNext()) {
            Rental each = rentals.next();          
	        result += "\t" + each.getMovie().getTitle()+ "\t" +
	            String.valueOf(each.calculateCharge()) + "\n";

        }
        result +=  "Amount owed is " + String.valueOf(calculateTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(calculateFrequentPoint()) +
             " frequent renter points";
        return result;
	}
	
	private double calculateTotalCharge() {
		double totalAmount = 0;
        Iterator<Rental> rentals = aRentals.iterator();
        while (rentals.hasNext()) {
            Rental each = rentals.next();  
	        totalAmount += each.calculateCharge();
        }
        
        return totalAmount;
	}
	
	private int calculateFrequentPoint() {
        int frequentRenterPoints = 0;
        Iterator<Rental> rentals = aRentals.iterator();
        while (rentals.hasNext()) {
            Rental each = rentals.next();  
            frequentRenterPoints += each.calculateFrequentPoint();
        }
        
        return frequentRenterPoints;
	}

	

	


	  
}
