package ca.mcgill.cs.swdesign.m4.demo;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import ca.mcgill.cs.swdesign.m4.demo.FlashLight;

public class TestFlashLight
{
	private FlashLight flashLight;

	@Before
	public void initialize()
	{
		this.flashLight = new FlashLight();
	}

	@Test
	public void testUpdateCount() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		Class<? extends FlashLight> flashLightClass = this.flashLight.getClass();

		Field countUpdateStrategyField;
		try
		{
			class StubCountUpdateStrategy implements CountUpdateStrategy
			{

				@Override
				public int update(int prevCount)
				{
					return prevCount + 1;
				}

			}
			StubCountUpdateStrategy countUpdateStrategy = new StubCountUpdateStrategy();

			countUpdateStrategyField = flashLightClass.getDeclaredField("countUpdateStrategy");
			countUpdateStrategyField.setAccessible(true);
			try
			{
				countUpdateStrategyField.set(this.flashLight, countUpdateStrategy);
			}
			catch (IllegalArgumentException | IllegalAccessException e1) { fail(); }
		}
		catch (NoSuchFieldException | SecurityException e) { fail(); }

		Method updateCountMethod;
		try
		{
			updateCountMethod = flashLightClass.getDeclaredMethod("updateCount");
			updateCountMethod.setAccessible(true);
			try
			{
				updateCountMethod.invoke(this.flashLight);
			}
			catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) { fail(); }
		}
		catch (NoSuchMethodException | SecurityException e) { fail(); }

		Field countField;
		try
		{
			countField = flashLightClass.getDeclaredField("count");
			countField.setAccessible(true);
			try
			{
				assertEquals(1, countField.get(this.flashLight));
			}
			catch (IllegalArgumentException | IllegalAccessException e) { fail(); }
		}
		catch (NoSuchFieldException | SecurityException e) { fail(); }
	}

	@Test
	public void testSetBrightnessLevel()
	{
		this.flashLight.setBrightnessLevel(5);
		assertEquals(5, this.flashLight.getBrightnessLevel());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testSetBrightnessLevelException_1()
	{
		this.flashLight.setBrightnessLevel(100);
		assertEquals(2, this.flashLight.getBrightnessLevel());
	}

	@Test
	public void testSetBrightnessLevelException_2()
	{
		try
		{
			this.flashLight.setBrightnessLevel(100);
			fail();
		}
		catch (IllegalArgumentException e) {}
	}
}
