package rest.client.example.hourly;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class HourlyForecastDTO {
    private String location;

    @JsonProperty("hourly_forecast")
    private List<HourlyWeather> hourlyForecast = new ArrayList<>();

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<HourlyWeather> getHourlyForecast() {
        return hourlyForecast;
    }

    public void setHourlyForecast(List<HourlyWeather> hourlyForecast) {
        this.hourlyForecast = hourlyForecast;
    }
}
