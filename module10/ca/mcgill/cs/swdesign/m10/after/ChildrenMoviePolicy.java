package ca.mcgill.cs.swdesign.m10.after;

public class ChildrenMoviePolicy extends PricePolicy
{

	ChildrenMoviePolicy()
	{
		super(2);
	}

	@Override
	public double getCharge(int daysRented)
	{
		double result = 0;
		result += 1.5;
        if (daysRented > 3)
            result += (daysRented - 3) * 1.5;
        return result;
	}

}
