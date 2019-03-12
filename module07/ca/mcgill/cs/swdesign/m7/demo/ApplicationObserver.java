package ca.mcgill.cs.swdesign.m7.demo;


public interface ApplicationObserver
{
	public void applicationAdded(JobSeeker pJobSeeker);
	public void applicationRemoved(JobSeeker pJobSeeker);
}
