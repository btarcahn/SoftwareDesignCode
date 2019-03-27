package ca.mcgill.cs.swdesign.m8.patterns;

public class OtherMovie
{	
	String aName;
	
	public OtherMovie(String pName)
	{
		aName = pName;
	}

	String getName() {
		return aName;
	}
	
	public void loadMovieFile() {
		/* operations for loading movie*/
	}
	
	public void playMovie() {
		/* operations for playing movie*/
	}

	public void closeMovieFile()
	{
		/* operations for closing movie file */	
	}
	

}
