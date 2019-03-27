package ca.mcgill.cs.swdesign.m8.patterns;

import java.util.Iterator;

public class Movie implements Performance
{
	OtherMovie aOtherMovie;

	public Movie(String pName)
	{
		aOtherMovie = new OtherMovie(pName);
	}

	@Override
	public String getTitle()
	{
		return aOtherMovie.getName();
	}

	public void startPerformance() 
	{
		aOtherMovie.loadMovieFile();
		aOtherMovie.playMovie();
		aOtherMovie.closeMovieFile();
		System.out.println("Done playing movie");
		
	}

}
