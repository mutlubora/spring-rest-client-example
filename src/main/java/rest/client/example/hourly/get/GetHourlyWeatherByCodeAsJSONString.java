package rest.client.example.hourly.get;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class GetHourlyWeatherByCodeAsJSONString {
    public static void main(String[] args) {
        String requestURI = "http://localhost:8080/v1/hourly/DELHI_IN";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("X-CURRENT-HOUR", "15");

        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate
                .exchange(requestURI, HttpMethod.GET, request, String.class);

        HttpStatusCode statusCode = response.getStatusCode();

        System.out.println("Status code: " + statusCode);

        if (statusCode.value() == HttpStatus.NO_CONTENT.value()) {
            System.out.println("No hourly forecast data available.");
        } else if (statusCode.value() == HttpStatus.OK.value()) {
            String body = response.getBody();
            System.out.println(body);
        }

    }
}
