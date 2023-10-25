package rest.client.example.realtime.get;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import rest.client.example.realtime.RealtimeWeather;

public class GetRealtimeWeatherByCodeAsObject {
    public static void main(String[] args) {
        String requestURI = "http://localhost:8080/v1/realtime/DELHI_IN";

        RestTemplate restTemplate = new RestTemplate();

        try {
            RealtimeWeather response = restTemplate.getForObject(requestURI, RealtimeWeather.class);
            System.out.println(response);

        } catch (RestClientResponseException e) {
            System.out.println("Response error code: " + e.getStatusCode());
            e.printStackTrace();        }
    }
}
