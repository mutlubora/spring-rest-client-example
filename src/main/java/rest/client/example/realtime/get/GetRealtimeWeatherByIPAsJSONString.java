package rest.client.example.realtime.get;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import rest.client.example.realtime.RealtimeWeather;

public class GetRealtimeWeatherByIPAsJSONString {
    public static void main(String[] args) {
        String requestURI = "http://localhost:8080/v1/realtime";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        String clientIpAddress = "103.48.198.141";	// Delhi, India
        headers.add("X-FORWARDED-FOR", clientIpAddress);

        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate
                .exchange(requestURI, HttpMethod.GET, request, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            String body = response.getBody();
            System.out.println(body);        }
    }
}
