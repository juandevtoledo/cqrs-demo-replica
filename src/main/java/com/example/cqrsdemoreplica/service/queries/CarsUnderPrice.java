package com.example.cqrsdemoreplica.service.queries;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarsUnderPrice {
    private BigDecimal referencePrice;
}
