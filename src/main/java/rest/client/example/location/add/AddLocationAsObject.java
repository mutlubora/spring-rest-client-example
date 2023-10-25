package rest.client.example.location.add;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import rest.client.example.location.Location;


public class AddLocationAsObject {
    public static void main(String[] args) {
        String requestURI = "http://localhost:8080/v1/locations";

        RestTemplate restTemplate = new RestTemplate();

        Location newLocation = new Location();
        newLocation.setCode("BNGL_IN");
        newLocation.setCityName("Bangalore");
        newLocation.setRegionName("Karnataka");
        newLocation.setCountryCode("IN");
        newLocation.setCountryName("India");

        HttpEntity<Location> request = new HttpEntity<>(newLocation);

        ResponseEntity<Location> response = restTemplate.postForEntity(requestURI, request, Location.class);

        HttpStatusCode statusCode = response.getStatusCode();

        Location addedLocation = response.getBody();

        System.out.println("Response status code: " + statusCode);
        System.out.println(addedLocation);



    }
}
