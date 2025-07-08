package weathercli;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;


public class WeatherCLI {

	public static void main(String[] args) {
		
		    String apiKey = "0fec47748a3ca95c61d26325ecfbed69";

		   /* if (args.length < 1) {
		        System.out.println("Usage: java WeatherCLI <city>");
		        return;
		    }*/

		    String city = "London";//args[0];
		    //String apiKey = "YOUR_API_KEY_HERE";

		    try {
		        String jsonResponse = getWeather(city, apiKey);
		        JSONObject json = new JSONObject(jsonResponse);

		        double temp = json.getJSONObject("main").getDouble("temp");
		        String weatherDescription = json.getJSONArray("weather")
		                                       .getJSONObject(0)
		                                       .getString("description");

		        System.out.println("Current weather in " + city + ":");
		        System.out.println("Temperature: " + temp + "°C");
		        System.out.println("Description: " + weatherDescription);
		    } catch (Exception e) {
		        System.out.println("Error fetching weather: " + e.getMessage());
		        e.printStackTrace();
		    }
	}
	
	public static String getWeather(String city, String apiKey) throws Exception {
	    HttpClient client = HttpClient.newHttpClient();
	    String url = "http://api.openweathermap.org/data/2.5/weather?q="
	                 + city + "&appid=" + apiKey + "&units=metric";

	    HttpRequest request = HttpRequest.newBuilder()
	            .uri(URI.create(url))
	            .build();

	    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	    return response.body();
	}

}
