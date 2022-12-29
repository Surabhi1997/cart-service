package com.example.cart.response;

import com.example.cart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {

    @Autowired
    UserService userService;

        public static ResponseEntity<?> responseBuilder(UserResponse userResponse, HttpStatus httpStatus, Object responseObject)
    {
        Map<String, Object> response = new HashMap<>();
        response.put("User Details", userResponse);
        response.put("httpStatus", httpStatus);
        response.put("Cart Items", responseObject);

        return new ResponseEntity<>(response, httpStatus);
    }


}
