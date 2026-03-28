package com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //identity strategy is best for mysql
    private Long id;
    @NotEmpty(message = "Name is required !")
    private String name;
    @Email(message = "Enter a valid email !")
    private String email;
    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;
    @Size(min=10, max=10, message = "Phone number must be 10 digits !")
    private String phone;
    @NotEmpty(message = "Address is required !")
    private String address;
}