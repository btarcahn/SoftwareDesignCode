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
	public void testUpdateCount() throws IllegalAccessException
	{
		Class<? extends FlashLight> counter = this.flashLight.getClass();

		Method updateCountMethod;
		try
		{
			updateCountMethod = counter.getDeclaredMethod("updateCount");
			updateCountMethod.setAccessible(true);
			try
			{
				updateCountMethod.invoke(this.flashLight);
			}
			catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) { fail(); }
		}
		catch (NoSuchMethodException | SecurityException e) { fail(); }

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

			countUpdateStrategyField = counter.getDeclaredField("countUpdateStrategy");
			countUpdateStrategyField.setAccessible(true);
//			try
//			{
				countUpdateStrategyField.set(counter, countUpdateStrategy);
//			}
//			catch (IllegalArgumentException | IllegalAccessException e1) { fail(); }
			try
			{
				assertEquals(countUpdateStrategyField.get(this.flashLight), 1);
			}
			catch (IllegalArgumentException | IllegalAccessException e) { fail(); }
		}
		catch (NoSuchFieldException | SecurityException e) { fail(); }

		Field countField;
		try
		{
			countField = counter.getField("count");
			countField.setAccessible(true);
			try
			{
				assertEquals(countField.get(this.flashLight), 1);
			}
			catch (IllegalArgumentException | IllegalAccessException e) { fail(); }
		}
		catch (NoSuchFieldException | SecurityException e) { fail(); }
	}

	@Test
	public void testSetBrightnessLevel() {
		this.flashLight.setBrightnessLevel(5);
		assertEquals(5, this.flashLight.getBrightnessLevel());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testSetBrightnessLevelException_1() {
		this.flashLight.setBrightnessLevel(100);
		assertEquals(2, this.flashLight.getBrightnessLevel());
	}
	
	@Test
	public void testSetBrightnessLevelException_2() {
		try
		{
			this.flashLight.setBrightnessLevel(100);
			fail();
		}
		catch (IllegalArgumentException e) {}
	}
}

//@Test
//public void testAutoPlay() throws Exception
//{
//	...
//   Field strategyField = GameEngine.class.getDeclaredField("aStrategy");
//   strategyField.setAccessible(true);
//   StubStrategy strategy = new StubStrategy();
//   GameEngine engine = GameEngine.instance();
//   strategyField.set(engine, strategy);
