package com.example.cqrsdemoreplica.service.commands;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class UpdateCarPriceCommand {
    private Long id;
    private BigDecimal price;
}
