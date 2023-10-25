package rest.client.example.realtime.get;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import rest.client.example.realtime.RealtimeWeather;

public class GetRealtimeWeatherByIPAsObject {
    public static void main(String[] args) {
        String requestURI = "http://localhost:8080/v1/realtime";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String clientIpAddress = "108.30.178.78";	// New York city, USA
        headers.add("X-FORWARDED-FOR", clientIpAddress);

        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<RealtimeWeather> response = restTemplate
                .exchange(requestURI, HttpMethod.GET, request, RealtimeWeather.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            RealtimeWeather body = response.getBody();
            System.out.println(body);
        }
    }
}
