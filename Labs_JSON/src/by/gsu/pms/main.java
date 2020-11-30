package by.gsu.pms;

import java.net.URL;

public class main {

    public static final String WEATHER_URL =
            "http://api.openweathermap.org/data/2.5/weather?q=Milan,it" +
                    "&units=metric&appid=268c69a422b4a76f6e17eafa263e58e0";

    public static void main(String[] args) {

        URL url = JSON.createUrl(WEATHER_URL);


        String resultJson = JSON.parseUrl(url);
        System.out.println("Полученный JSON:\n" + resultJson);

        JSON.parseCurrentWeatherJson(resultJson);

    }
}
