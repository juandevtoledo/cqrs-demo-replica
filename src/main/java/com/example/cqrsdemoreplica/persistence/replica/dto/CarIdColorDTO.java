package com.example.cqrsdemoreplica.persistence.replica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarIdColorDTO {
    private Long id;
    private String color;
}
