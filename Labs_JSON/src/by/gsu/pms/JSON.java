package by.gsu.pms;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class JSON {

    public static String parseUrl(URL url) {
        if (url == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {

            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                stringBuilder.append(inputLine);
                System.out.println(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static void parseCurrentWeatherJson(String resultJson) {
        generator_html constructor = null;
        try {

            JSONObject weatherJsonObject = (JSONObject) JSONValue.parseWithException(resultJson);

            JSONArray weatherArray = (JSONArray) weatherJsonObject.get("weather");
            JSONObject weatherData = (JSONObject) weatherArray.get(0);

            JSONObject mainArray = (JSONObject) weatherJsonObject.get("main");
            JSONObject windArray = (JSONObject) weatherJsonObject.get("wind");
            JSONObject cloudsArray = (JSONObject) weatherJsonObject.get("clouds");
            JSONObject sysArray = (JSONObject) weatherJsonObject.get("sys");

            String city = weatherJsonObject.get("name").toString();
            String country = sysArray.get("country").toString();

            String weatherDesriptionShort = String.valueOf(weatherData.get("main"));
            String weatherDescriptionLong = String.valueOf(weatherData.get("description"));

            String iconId = weatherData.get("icon").toString();
            String iconUrl = "http://openweathermap.org/img/w/"+iconId+".png";


            int minTemp = (int) ((double) mainArray.get("temp_min"));
            int maxTemp = (int) ((double) mainArray.get("temp_max"));
            int currentTemp = (int) ((double) mainArray.get("temp"));
            String humidity = String.valueOf(mainArray.get("humidity"));
            String pressure = String.valueOf(mainArray.get("pressure"));
            String windSpeed = String.valueOf(windArray.get("speed"));
            String windAngle = String.valueOf(windArray.get("deg"));
            long clouds = (long) cloudsArray.get("all");

            constructor = new generator_html(city,
                    country,
                    iconUrl,
                    weatherDesriptionShort,
                    weatherDescriptionLong,
                    minTemp,
                    maxTemp,
                    currentTemp,
                    humidity,
                    pressure,
                    windSpeed,
                    windAngle,
                    clouds);
            System.out.println(constructor.getWidgetCode());

        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
        constructor.saveWidgetToFile();
    }

    public static URL createUrl(String link) {
        try {
            return new URL(link);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
