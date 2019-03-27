import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
//import org.powermock.modules.agent.PowerMockAgent;
//import org.powermock.modules.junit4.rule.PowerMockRule;




//@RunWith(JUnit4.class)	
@RunWith(PowerMockRunner.class)
@PrepareForTest({WeatherMan.class})
public class testWeatherMan {
//	@Rule
 //   public PowerMockRule rule = new PowerMockRule();
	@Mock
	Weather weather;

/*
  	static {
 
	       PowerMockAgent.initializeIfNeeded();
	   }
	   */
	@Test
	public void testReportTemperature() {
		String temperature = "33";
		WeatherMan weatherMan = new WeatherMan();
		PowerMockito.doReturn(temperature).when(weather).getTemperature();
		String result = weatherMan.reportTemperature(weather);
		Assert.assertEquals(temperature, result);
	}
	
	@Test
	public void testReportUVIndex() {
		String UVIndex = "150";
		PowerMockito.mockStatic(WeatherMan.class);
		PowerMockito.when(WeatherMan.reportUVIndex(weather)).thenReturn("150");
		String result = WeatherMan.reportUVIndex(weather);
		Assert.assertEquals(UVIndex, result);
	}
	
	@Test
	public void testReportUVIndexViaWeather() {
		String UVIndex = "150";
		PowerMockito.doReturn(UVIndex).when(weather).getUltraVioletIndex();
		String result = WeatherMan.reportUVIndex(weather);
		Assert.assertEquals(UVIndex, result);
	}

}
