package by.gsu.pms;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;

public class generator_html {
    public generator_html(String city,
                             String country,
                             String iconUrl,
                             String weatherDesriptionShort,
                             String weatherDescriptionLong,
                             int minTemp, int maxTemp,
                             int currentTemp,
                             String humidity,
                             String pressure,
                             String windSpeed,
                             String windAngle,
                             long clouds) {
        this.city = city;
        this.country = country;
        this.iconUrl = iconUrl;
        this.weatherDesriptionShort = weatherDesriptionShort;
        this.weatherDescriptionLong = weatherDescriptionLong;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.currentTemp = currentTemp;
        this.humidity = humidity;
        this.pressure = pressure;
        this.windSpeed = windSpeed;
        this.windAngle = windAngle;
        this.clouds = clouds;
    }
    String city;
    String country;
    String iconUrl;
    String weatherDesriptionShort;
    String weatherDescriptionLong;
    int minTemp;
    int maxTemp;
    int currentTemp;
    String humidity;
    String pressure;
    String windSpeed;
    String windAngle;
    long clouds;

    public String getWidgetCode() {
        String paragraphCloseTag = "</p>\n";
        return "<h3>Погода для "+ city +", "+country+"</h3>\n" +
                "<img class=\"weather-icon\" src=\""+iconUrl+"\">\n" +
                "<p>Описание погоды: "+ weatherDesriptionShort +paragraphCloseTag +
                "<p>Расширенное описание погоды: "+ weatherDescriptionLong +paragraphCloseTag +
                "<p>Текущая температура: "+ currentTemp +paragraphCloseTag +
                "<p>Давление: "+ pressure +paragraphCloseTag +
                "<p>Влажность: "+ humidity +paragraphCloseTag +
                "<p>Минимальная температура на сегодняшний день: "+ minTemp +paragraphCloseTag +
                "<p>Максимальная температура на сегодняшний день: "+ maxTemp +paragraphCloseTag +
                "<p>Скорость ветра: "+ windSpeed +paragraphCloseTag +
                "<p>Направление ветра: "+ windAngle +paragraphCloseTag +
                "<p>Облачность: "+ clouds +paragraphCloseTag;
    }

    public void saveWidgetToFile() {
        String widgetCode = getWidgetCode();

        try (FileWriter myWriter = new FileWriter("weather_data.html", Charset.forName("Windows-1251"))) {
            myWriter.write(widgetCode);
            System.out.println("Успешно записал в файл.");
        } catch (IOException e) {
            System.out.println("Возникла ошибка.");
            e.printStackTrace();
        }

    }
}
