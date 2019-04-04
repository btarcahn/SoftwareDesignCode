package ca.mcgill.cs.swdesign.m10.before;

public class Movie {

	  public static final int  CHILDREN = 2;
	  public static final int  REGULAR = 0;
	  public static final int  NEW_RELEASE = 1;

	  private String aTitle;
	  private int aPriceCode;

	  public Movie(String title, int priceCode) {
	      aTitle = title;
	      aPriceCode = priceCode;
	  }

	  public int getPriceCode() {
	      return aPriceCode;
	  }

	  public void setPriceCode(int arg) {
	     aPriceCode = arg;
	  }

	  public String getTitle (){
	      return aTitle;
	  }
}


