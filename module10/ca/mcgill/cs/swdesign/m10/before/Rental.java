package ca.mcgill.cs.swdesign.m10.before;

public class Rental
{
	private Movie aMovie;
    private int aDaysRented;

    public Rental(Movie movie, int daysRented) {
      aMovie = movie;
      aDaysRented = daysRented;
    }
    public int getDaysRented() {
      return aDaysRented;
    }
    public Movie getMovie() {
      return aMovie;
    }

}
