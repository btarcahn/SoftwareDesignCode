package ca.mcgill.cs.swdesign.m7.demo;

import java.time.LocalDateTime;

public interface JobSeeker
{
	public void noticeMe(LocalDateTime date);
	public TechSpecialty getTechSpecialty();
	public int getYearOfExperience();
	public boolean haveReference();
}
