package ca.mcgill.cs.swdesign.m7.demo;

/**
 * Provide state of interest (interview schedule) to JobSeeker
 * The notification to JobSeeker need to be called explicitly by client
 *  
 */
public interface JobProvider
{
	public void acceptApplication(JobSeeker pJobSeeker);
	public void withdrawApplication(JobSeeker pJobSeeker);
	public void noticeCandidates();
}
