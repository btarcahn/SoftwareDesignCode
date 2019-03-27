package ca.mcgill.cs.swdesign.m8.patterns;

public class MovieFactory implements PerformanceFactory 
{

	@Override
	public Movie createPerformance(String pName)
	{
		return new Movie(pName);
	}

}
