package rest.client.example.location.list;

import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.*;
import rest.client.example.location.Location;

import java.util.Collections;

public class ListLocationsAsObjectArray {
    public static void main(String[] args) {
        String requestURI = "http://localhost:8080/v1/locations";

        RestTemplate restTemplate = new RestTemplate();

        try {
            Location[] locations = restTemplate.getForObject(requestURI, Location[].class);

            if (locations != null && locations.length > 0) {
                for (Location location : locations) {
                    System.out.println(location);
                }
            }
        } catch (HttpClientErrorException ex) {
            System.out.println("Client Error: " + ex.getStatusCode() + " - " + ex.getStatusText());
            ex.printStackTrace();
        } catch (HttpServerErrorException ex) {
            System.out.println("Server Error: " + ex.getStatusCode() + " - " + ex.getStatusText());
            ex.printStackTrace();
        } catch (UnknownHttpStatusCodeException ex) {
            System.out.println("Unknown Http Status Code Error: " + ex.getStatusCode());
            ex.printStackTrace();
        }

    }
}
