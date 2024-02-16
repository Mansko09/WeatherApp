import netscape.javascript.JSObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

//class to retrieve weather data from API
public class WeatherApp {
    public static JSONObject getWeatherData (String locationName){
        JSONArray locationData= getLocationData(locationName);
        return null;

    }

    //retrieves geographic coordinates for given location name
    public static JSONArray getLocationData(String locationName){
        //replace any whitespace in location name to + to adhere to API's request format
        locationName=locationName.replaceAll(" ","+");
        //build API url with location parameter
        String urlString = "https://geocoding-api.open-meteo.com/v1/search?name="+locationName+"&count=10&language=en&format=json";

        try{
            //call API and get a response
            HttpURLConnection conn = fetchApiResponse(urlString);

            //check response status
            //200 means successful connection
            if (conn.getResponseCode()!=200){
                System.out.println("Error: Could not connect to API");
                return null;
            }else{
                //store the API result
                StringBuilder resultJson = new StringBuilder();
                Scanner scanner = new Scanner(conn.getInputStream());
                while(scanner.hasNext()){
                    resultJson.append(scanner.nextLine());
                }
                scanner.close();
                conn.disconnect();//close url connection

                //parse the JSON string into a JSON object
                JSONParser parser = new JSONParser();
                JSONObject resultJsonObj = (JSONObject) parser.parse(String.valueOf(resultJson));

                //get the list of location data the API generated from the location name
                JSONArray locationData = (JSONArray) resultJsonObj.get("results");
                return locationData;
            }
        }catch(Exception e){
            e.printStackTrace();
            return null;

        }
    }
    private static HttpURLConnection fetchApiResponse(String urlString){
        try{
            //attempt to create connection
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //set request method to get
            conn.setRequestMethod("GET");
            //connect to our API
            conn.connect();
        }catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

}
