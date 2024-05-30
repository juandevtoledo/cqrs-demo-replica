package com.example.cqrsdemoreplica.service;

import java.util.List;

import com.example.cqrsdemoreplica.persistence.replica.dto.CarIdColorDTO;
import com.example.cqrsdemoreplica.persistence.replica.dto.CardBrandColorDTO;
import com.example.cqrsdemoreplica.service.queries.CarsByBrand;
import com.example.cqrsdemoreplica.service.queries.CarsUnderPrice;

public interface CarQueryService {
    List<CarIdColorDTO> findAllCarIdColorByBrand(CarsByBrand carsByBrand);
    List<CardBrandColorDTO> findAllCarBrandColorUnderPrice(CarsUnderPrice carsUnderPrice);
}
