package ca.mcgill.cs.swdesign.m10.after;

public class RegularMoviePolicy extends PricePolicy
{

	RegularMoviePolicy()
	{
		super(0);
	}

	@Override
	public double getCharge(int daysRented)
	{
		double result = 0;
		result += 2;
        if (daysRented > 2)
            result += (daysRented - 2) * 1.5;
        return result;
	}

}
