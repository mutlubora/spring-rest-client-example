package rest.client.example.location.add;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;


public class AddLocationAsJSONString {
    public static void main(String[] args) {
        String requestURI = "http://localhost:8080/v1/locations";

        RestTemplate restTemplate = new RestTemplate();
        
        String json = """
                {
                  "code": "MADRID_ES",
                  "city_name": "Madrid",
                  "region_name": "Community of Madrid",
                  "country_code": "ES",
                  "country_name": "Spain",
                  "enabled": true
                }
                """;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(json, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(requestURI, request, String.class);

        HttpStatusCode statusCode = response.getStatusCode();

        String addedLocationJSON = response.getBody();

        System.out.println("Response status code: " + statusCode);
        System.out.println(addedLocationJSON);



    }
}
