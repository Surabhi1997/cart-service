package com.example.cart.response;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private Long id;
    private String firstName;
    private String lastName;

    private String email;
    private String password;

    private String mobile;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private String role;


}
