package com.example.cqrsdemoreplica.persistence.replica;

import java.math.BigDecimal;
import java.util.List;

import com.example.cqrsdemoreplica.persistence.replica.dto.CarIdColorDTO;
import com.example.cqrsdemoreplica.persistence.replica.dto.CardBrandColorDTO;


public interface CarReadRepository {
    List<CarIdColorDTO> findAllCarIdColorByBrand(String brand);
    List<CardBrandColorDTO> findAllCarBrandColorUnderPrice(BigDecimal referencePrice);
}
