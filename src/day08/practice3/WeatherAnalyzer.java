package day08.practice3;

import static day08.practice3.WeatherConstants.*;

public class WeatherAnalyzer {
    public static boolean checkTemperatureAlert(double temperature) {
        return (temperature > MAX_TEMPERATURE_ALERT || temperature < MIN_TEMPERATURE_ALERT);
    }


    public static boolean checkPrecipitationAlert(double precipitation) {
        return precipitation > PRECIPITATION_ALERT;
    }
}

