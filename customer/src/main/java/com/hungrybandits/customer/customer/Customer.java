package com.hungrybandits.customer.customer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @SequenceGenerator(name = "customer_sequence", sequenceName = "customer_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_sequence")
    private Integer id;
    private String name;
    private Integer age;
    private String email;
}
