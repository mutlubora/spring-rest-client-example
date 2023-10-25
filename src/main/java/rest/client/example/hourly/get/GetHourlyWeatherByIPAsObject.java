package rest.client.example.hourly.get;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import rest.client.example.hourly.HourlyForecastDTO;
import rest.client.example.hourly.HourlyWeather;

import java.util.List;

public class GetHourlyWeatherByIPAsObject {
    public static void main(String[] args) {
        String requestURI = "http://localhost:8080/v1/hourly";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("X-CURRENT-HOUR", "15");
        headers.add("X-FORWARDED-FOR", "103.48.198.141"); // Delhi, India

        HttpEntity<HourlyForecastDTO> request = new HttpEntity<>(headers);

        ResponseEntity<HourlyForecastDTO> response = restTemplate
                .exchange(requestURI, HttpMethod.GET, request, HourlyForecastDTO.class);

        HttpStatusCode statusCode = response.getStatusCode();

        System.out.println("Status code: " + statusCode);

        if (statusCode.value() == HttpStatus.NO_CONTENT.value()) {
            System.out.println("No hourly forecast data available.");
        } else if (statusCode.value() == HttpStatus.OK.value()) {
            HourlyForecastDTO dto = response.getBody();
            System.out.println("Location: " + dto.getLocation());

            List<HourlyWeather> hourlyForecast = dto.getHourlyForecast();
            hourlyForecast.forEach(System.out::println);
        }

    }
}
