package weathercli;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;


public class WeatherCLI {


	static String openWeatherApiKey = System.getenv("OPENWEATHER_API_KEY");
    static  String timezonedbApiKey = System.getenv("TIMEZONEDB_API_KEY");
	static HttpClient client = HttpClient.newHttpClient();
	public static void main(String[] args) {
		
		    //String apiKey = "0fec47748a3ca95c61d26325ecfbed69";

		    if (args.length < 1) {
		        System.out.println("Usage: java WeatherCLI <city>");
		        return;
		    }
		    if (openWeatherApiKey == null || timezonedbApiKey == null) {
		        System.err.println("Missing API keys. Please set OPENWEATHER_API_KEY and TIMEZONEDB_API_KEY.");
		        return;
		    }
		    String city = args[0];

		    try {
		        String jsonResponse = getWeather(city);
		        JSONObject json = new JSONObject(jsonResponse);

		        double temp = json.getJSONObject("main").getDouble("temp");
		        String weatherDescription = json.getJSONArray("weather")
		                                       .getJSONObject(0)
		                                       .getString("description");

		        System.out.println("Current weather in " + city + ":");
		        System.out.println("Temperature: " + temp + "°C");
		        System.out.println("Description: " + weatherDescription);
		        
		        JSONObject coord = json.getJSONObject("coord");
	            double lat = coord.getDouble("lat");
	            double lon = coord.getDouble("lon");
	            
	            System.out.println("Coordinates: Latitude=" + lat + ", Longitude=" + lon);
		        
		        JSONObject timeData = new JSONObject(getTime(lat,lon));

		        String localTime = timeData.getString("formatted");
		        System.out.println("Current local time: " + localTime);
	            
	            
		    } catch (Exception e) {
		        System.out.println("Error fetching weather: " + e.getMessage());
		        e.printStackTrace();
		    }
		    
	}
	
	public static String getWeather(String city) throws Exception {
	    String url = "http://api.openweathermap.org/data/2.5/weather?q="
	                 + city + "&appid=" + openWeatherApiKey + "&units=metric";

	    HttpResponse<String> response = sendRequest(url);
	    return response.body();
	}
	
public static String getTime(double lat,double lon) throws Exception {
	 String timeUrl = "http://api.timezonedb.com/v2.1/get-time-zone?key="
             + timezonedbApiKey + "&format=json&by=position&lat=" 
             + lat + "&lng=" + lon;
		 		
			HttpResponse<String> response = sendRequest(timeUrl);
			 return response.body();			
	}
	
	public static HttpResponse<String> sendRequest(String url) throws IOException, InterruptedException{
		HttpRequest req= HttpRequest.newBuilder().uri(URI.create(url)).build();
		HttpResponse<String> response = client.send(req, HttpResponse.BodyHandlers.ofString());
		
		if(response.statusCode()!=200) {
			throw new IOException("API Call failed with status "+response.statusCode());
		}	
		return response;
	}
}
