package rest.client.example.location.delete;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class DeleteLocationSimple {
    public static void main(String[] args) {

        String requestURI = "http://localhost:8080/v1/locations/{code}";

        Map<String, String> params = new HashMap<>();
        params.put("code", "BNGL_IN");

        RestTemplate restTemplate = new RestTemplate();
        try {
            restTemplate.delete(requestURI, params);
            System.out.println("Location deleted.");
        } catch (RestClientResponseException e) {
            System.out.println("Error status code: " + e.getStatusCode());
        }

    }
}
