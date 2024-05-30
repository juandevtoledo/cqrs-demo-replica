package com.example.cqrsdemoreplica.persistence.model;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class Car {
    private Long id;
    private String brand;
    private String color;
    private BigDecimal price;
}
