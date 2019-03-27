package ca.mcgill.cs.swdesign.m8.patterns;

public class MusicalFactory implements PerformanceFactory
{
	@Override
	public Musical createPerformance(String pName)
	{
		return new Musical(pName);
	}

}
