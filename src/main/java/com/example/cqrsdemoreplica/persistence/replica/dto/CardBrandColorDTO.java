package com.example.cqrsdemoreplica.persistence.replica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CardBrandColorDTO {
    private String brand;
    private String color;
}
