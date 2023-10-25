package rest.client.example.hourly.update;

import org.springframework.http.*;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import rest.client.example.hourly.HourlyForecastDTO;
import rest.client.example.hourly.HourlyWeather;

public class UpdateHourlyWeatherAsObject {
    public static void main(String[] args) {
        String requestURI = "http://localhost:8080/v1/hourly/{locationCode}";
        String locationCode = "DELHI_IN";


        RestTemplate restTemplate = new RestTemplate();

        HourlyWeather forecast1 = new HourlyWeather();
        forecast1.setHourOfDay(9);
        forecast1.setTemperature(15);
        forecast1.setPrecipitation(10);
        forecast1.setStatus("Clear");

        HourlyWeather forecast2 = new HourlyWeather();
        forecast2.setHourOfDay(10);
        forecast2.setTemperature(16);
        forecast2.setPrecipitation(11);
        forecast2.setStatus("Clear");

        HourlyWeather forecast3 = new HourlyWeather();
        forecast3.setHourOfDay(11);
        forecast3.setTemperature(17);
        forecast3.setPrecipitation(12);
        forecast3.setStatus("Partly Sunny");

        HourlyWeather[] hourlyForecast = new HourlyWeather[] {forecast1, forecast2, forecast3};

        var request = new HttpEntity<Object>(hourlyForecast);

        ResponseEntity<HourlyForecastDTO> response = restTemplate
                .exchange(requestURI, HttpMethod.PUT, request, HourlyForecastDTO.class, locationCode);

        HttpStatusCode statusCode = response.getStatusCode();
        System.out.println("Status code: " + statusCode);

        if (statusCode.value() == HttpStatus.OK.value()) {
            System.out.println("Hourly weather data updated.");

            HourlyForecastDTO dto = response.getBody();

            System.out.println("Location: " + dto.getLocation());
            dto.getHourlyForecast().stream()
                    .forEach(System.out::println);
        }

    }
}
