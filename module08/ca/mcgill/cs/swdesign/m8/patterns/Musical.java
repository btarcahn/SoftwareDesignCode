package ca.mcgill.cs.swdesign.m8.patterns;

import java.util.Iterator;

public class Musical implements Performance
{
	String aName;

	public Musical(String pName)
	{
		aName = pName;
	}

	@Override
	public String getTitle()
	{
		return aName;
	}

	@Override
	public void startPerformance()
	{
		// TODO Auto-generated method stub
	}

}
