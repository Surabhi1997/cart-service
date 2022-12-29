package com.example.cart.service;

import com.example.cart.model.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService {

       Cart addItem(Cart cart);

     List<Cart> getCartItems(Long userId);

    // communicate with order-service
     int totalAmount(Long userId);

}
