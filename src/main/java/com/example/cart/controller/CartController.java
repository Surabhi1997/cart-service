package com.example.cart.controller;

import com.example.cart.model.Cart;
import com.example.cart.response.UserResponse;
import com.example.cart.service.CartService;
import com.example.cart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;

    @Autowired
    UserService userService;

    @PostMapping
    public Cart addItemToCart(@RequestBody Cart cart)
    {
       return cartService.addItem(cart);
    }

    @GetMapping("/{userId}")
    public List<Cart> getCartItems(@PathVariable Long userId)
    {

        return cartService.getCartItems(userId);
    }

    @GetMapping("/userDetails/{userId}")
    public UserResponse getUserDetails(@PathVariable Long userId) throws IOException {
        return userService.getUserDetails(userId);
    }

}
