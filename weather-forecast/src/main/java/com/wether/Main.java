package com.wether;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

/**
 * @author sureshshanmugam
 *
 *
 * This Main class is used to read 2 values from user and 
 * pass the values into weather report API to get the weather report
 * for next 5 days.
 */
public class Main {
	
	private static String WEATHER_API_URL = "https://api.weather.gov/points/";

	public static void main(String[] args) {
		
		try {
			
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the latitude longitude pair values");
			double latitude = scanner.nextDouble();
			double longitude = scanner.nextDouble();
			
			StringBuffer sb = new StringBuffer(WEATHER_API_URL);
			sb.append(String.valueOf(latitude));
			sb.append(",");
			sb.append(String.valueOf(longitude));
			
			Forecast forecast = getForecastResponse(sb.toString());
			if(forecast != null) {
				String forecastUrl = forecast.getProperties().getForecast();
				System.out.println("Successfully got the weather Points. The URL is : "+forecastUrl);
				Forecast forecastReport = getForecastResponse(forecastUrl);
				if(forecastReport != null) {
					
					System.out.println("Successfully got the weather Reports.");
					System.out.println("The following weather reports showing for the next 5 days from now");
					
					List<ForecastPeriods> periods = forecastReport.getProperties().getPeriods();
		            
		            LocalDateTime today = LocalDateTime.now();
		            LocalDateTime endDate = today.plusDays(5);
		           
		            periods.stream().filter(
		            		a -> {
		            			LocalDateTime sDate = LocalDateTime.parse(a.getStartTime(),DateTimeFormatter.ISO_DATE_TIME);
		            			LocalDateTime eDate = LocalDateTime.parse(a.getEndTime(),DateTimeFormatter.ISO_DATE_TIME);
		            			return sDate.isAfter(today) && eDate.isBefore(endDate);
		            		}).forEach(period -> System.out.println(period));
					
				}
				
			}
			
		} catch(Exception exception) {
			System.out.println("Exception occurred while getting weather report"+exception);
		}

	}
	
	/**
	 * 
	 * @param apiUrl - API URL
	 * @return Forecast - Response Object from the weather api
	 * 
	 */
	private static Forecast getForecastResponse(String apiUrl) {
		
		Forecast forecast = null;
		HttpURLConnection connection = null;
		
		try {
			URL url = new URL(apiUrl);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Accept", "application/json");
            if (connection.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + connection.getResponseCode()+" And the Response is : "+connection.getResponseMessage());
            }
            InputStreamReader in = new InputStreamReader(connection.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String apiResponseString;
            StringBuffer sb = new StringBuffer();
            while ((apiResponseString = br.readLine()) != null) {
            	sb.append(apiResponseString);
            }
            
            Gson geson = new Gson(); 
            forecast = geson.fromJson(sb.toString(), Forecast.class);
            
       } catch(Exception exception) {
			
    	   System.out.println("Exception occurred while getting weather forecast from the api"+exception);
		} finally {
			if(connection != null) {
				connection.disconnect();
			}
		}
		
		return forecast;
		
	}

}
