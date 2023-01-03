package com.example.cart.service;

import com.example.cart.exception.UserNotFoundException;
import com.example.cart.model.Cart;
import com.example.cart.repository.CartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cardRepository;

    @Override
    public Cart addItem(Cart cart) {
        return (Cart) cardRepository.save(cart);
    }

    @Override
    public List<Cart> getCartItems(Long userId) {
        List<Cart> cartItems = cardRepository.findByUserId(userId);
        if (cartItems.size() != 0) {
            return cardRepository.findByUserId(userId);
        } else {
            throw new UserNotFoundException("User not found with id : " + userId);
        }
    }

    // communicate with order-service
    @Override
    public int totalAmount(Long userId) {
        List<Cart> cartList = cardRepository.findByUserId(userId);
        return cartList.stream().map(Cart::getPrice).mapToInt(i -> Integer.parseInt(i)).sum();

    }

}