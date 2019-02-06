package ca.mcgill.cs.swdesign.m4.demo;

public class ExponentialUpdateStrategy implements CountUpdateStrategy
{

	@Override
	public int update(int prevCount)
	{
		if (prevCount ==  0)
		{
			prevCount += 1;
		}
		return prevCount * 2;
	}

}
