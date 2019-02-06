package ca.mcgill.cs.swdesign.m4.demo;

public class FlashLight {

	private int count;
	private int brightnessLevel;
	private CountUpdateStrategy countUpdateStrategy;

	FlashLight()
	{
		this.count = 0;
		this.countUpdateStrategy = new ExponentialUpdateStrategy();
		this.brightnessLevel = 0;
	}

	public void setBrightnessLevel(int pBrightnessLevel) throws IllegalArgumentException
	{
		if (pBrightnessLevel > 5 || pBrightnessLevel < 0)
		{
           throw new IllegalArgumentException("BrightnessLevel should in the range of [0-5].");
		}
		this.updateCount();
		this.brightnessLevel = pBrightnessLevel;
	}

	private void updateCount()
	{
		this.count = this.countUpdateStrategy.update(this.count);
	}

	public int getBrightnessLevel()
	{
		return this.brightnessLevel;
	}

}
