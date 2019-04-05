package ca.mcgill.cs.swdesign.m10.after;

public class NewReleaseMoviePolicy extends PricePolicy
{

	NewReleaseMoviePolicy()
	{
		super(1);
	}
	
	@Override
	public int getFrequentPoint(int daysRented) {
		if (daysRented>1)
			return 2;
		else 
			return 1;
	}

	@Override
	public double getCharge(int daysRented)
	{
		return daysRented * 3;
	}
	

}
