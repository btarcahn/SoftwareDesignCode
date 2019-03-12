package ca.mcgill.cs.swdesign.m7.demo;

/**
 * Provide state of interest (JobSeeker added or removed) to ApplicationObserver
 * The notification to ApplicationObserver is called automa
 *  
 */
public interface ApplicationPool
{
	public void addApplicationObserver(ApplicationObserver pApplicationObservers);
	public void removeApplicationObserver(ApplicationObserver pApplicationObservers);
	
}
