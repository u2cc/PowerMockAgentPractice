
public class WeatherMan {
	
	public String reportTemperature(Weather weather) {
		System.out.printf("Today's temperature is %s degrees", weather.getTemperature());
		return weather.getTemperature();	
	}
	
	public static String reportUVIndex(Weather weather) {
		System.out.printf("Today's UV Index is %s", weather.getUltraVioletIndex());
		return weather.getUltraVioletIndex();
	}
}
