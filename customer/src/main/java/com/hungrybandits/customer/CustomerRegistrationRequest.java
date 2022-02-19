package com.hungrybandits.customer;

import lombok.Data;

@Data
public class CustomerRegistrationRequest {
    private String name;
    private Integer age;
    private String email;
}
