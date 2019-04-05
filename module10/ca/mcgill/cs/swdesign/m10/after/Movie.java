package ca.mcgill.cs.swdesign.m10.after;

public class Movie {

	  public static final int  CHILDREN = 2;
	  public static final int  REGULAR = 0;
	  public static final int  NEW_RELEASE = 1;

	  private String aTitle;
	  private PricePolicy aPriceCode;

	  /**
	   * 
	   * @pre title!=null && priceCode <=2 && priceCode >= 0
	   */
	  public Movie(String title, int priceCode) {
		  assert title!=null && priceCode>=0 && priceCode<=2;
	      aTitle = title;
	      setPriceCode(priceCode);
	  }

	  public int getPriceCode() {
	      return aPriceCode.getPriceCode();
	  }

	  /**
	   * 
	   * @pre priceCode <=2 && priceCode >= 0
	   */
	  public void setPriceCode(int priceCode) {
		  assert priceCode>=0 && priceCode<=2;
		  switch (priceCode) {
		    case 0:
		    	aPriceCode = new RegularMoviePolicy();
		    	break;
		    case 1:
		    	aPriceCode = new NewReleaseMoviePolicy();
		    	break;
		    case 2:
		    	aPriceCode = new ChildrenMoviePolicy();
		    	break;
		    default:
		    	assert false;       
		  }
	  }

	  public String getTitle (){
	      return aTitle;
	  }
	  
	  public double getCharge(int daysRented) {
		  return aPriceCode.getCharge(daysRented);
	  }
	  
	  public int getFrequentPoint(int daysRented) {
		return aPriceCode.getFrequentPoint(daysRented);
	  }
}


