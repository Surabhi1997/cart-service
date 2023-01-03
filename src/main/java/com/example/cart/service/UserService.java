package com.example.cart.service;

import com.example.cart.response.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@Component
public class UserService {

    public UserResponse getUserDetails(Long userId) throws RestClientException, IOException
    {
        String baseUrl = "http://localhost:8080/users/details/" + userId;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserResponse> response = null;
        try
        {
            response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), UserResponse.class);
            System.out.println(response.getBody());
            return response.getBody();
        }
        catch(Exception e)
        {
            throw new NullPointerException("No user found with Id : " + userId);
        }

    }

    private static HttpEntity<?> getHeaders() throws IOException
    {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return new HttpEntity<>(headers);
    }

}