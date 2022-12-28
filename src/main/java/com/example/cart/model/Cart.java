package com.example.cart.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@Data
@Entity
@Table(name = "cart")
public class Cart {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cartId;
    private String productName;
    private String price;

    private Long userId;


}
