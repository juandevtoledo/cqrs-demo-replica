package com.example.cqrsdemoreplica.service.commands;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CreateCarCommand {
    private String brand;
    private String color;
    private BigDecimal price;
}

