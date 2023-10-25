package rest.client.example.location.update;

import org.springframework.http.*;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import rest.client.example.location.Location;


public class UpdateLocationAsObject {
    public static void main(String[] args) {
        String requestURI = "http://localhost:8080/v1/locations";

        RestTemplate restTemplate = new RestTemplate();

        Location location = new Location();
        location.setCode("DANA_VN");
        location.setCityName("Da Nang");
        location.setRegionName("Da Nang");
        location.setCountryCode("VN");
        location.setCountryName("Vietnam");
        location.setEnabled(true);

        HttpEntity<Location> request = new HttpEntity<>(location);

        ResponseEntity<Location> response = restTemplate
                .exchange(requestURI, HttpMethod.PUT, request, Location.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            Location updatedLocation = response.getBody();
            System.out.println(updatedLocation);
        }
    }
}
