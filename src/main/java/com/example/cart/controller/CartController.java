package com.example.cart.controller;

import com.example.cart.model.Cart;
import com.example.cart.response.ResponseHandler;
import com.example.cart.service.CartService;
import com.example.cart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @Autowired
    UserService userService;

    @PostMapping
    public Cart addItemToCart(@RequestBody Cart cart) {
        return cartService.addItem(cart);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getCartItems(@PathVariable Long userId) throws IOException {
        return ResponseHandler.responseBuilder(userService.getUserDetails(userId), HttpStatus.OK, cartService.getCartItems(userId));
    }

    @GetMapping("/total/{userId}")
    public int orderTotal(@PathVariable Long userId) {
        return cartService.totalAmount(userId);
    }

}