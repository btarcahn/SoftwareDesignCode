package ca.mcgill.cs.swdesign.m10.after;

public abstract class PricePolicy
{
	private final int aPriceCode;
	
	PricePolicy(int pPricePolicy) {
		aPriceCode = pPricePolicy;
	}
	public abstract double getCharge(int daysRented);
	public int getFrequentPoint(int daysRented) {
		return 1;
	}
	protected int getPriceCode() {return aPriceCode;}
}
