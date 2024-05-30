package com.example.cqrsdemoreplica.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.cqrsdemoreplica.persistence.replica.CarReadRepository;
import com.example.cqrsdemoreplica.persistence.replica.dto.CarIdColorDTO;
import com.example.cqrsdemoreplica.persistence.replica.dto.CardBrandColorDTO;
import com.example.cqrsdemoreplica.service.queries.CarsByBrand;
import com.example.cqrsdemoreplica.service.queries.CarsUnderPrice;


@Service
public class CarQueryServiceImpl implements CarQueryService {

    private final CarReadRepository carReadRepository;

    public CarQueryServiceImpl(CarReadRepository carReadRepository) {
        this.carReadRepository = carReadRepository;
    }

    @Override
    public List<CarIdColorDTO> findAllCarIdColorByBrand(CarsByBrand carsByBrand) {
        return this.carReadRepository
                .findAllCarIdColorByBrand(carsByBrand.getBrand());
    }

    @Override
    public List<CardBrandColorDTO> findAllCarBrandColorUnderPrice(CarsUnderPrice carsUnderPrice) {
        return this.carReadRepository
                .findAllCarBrandColorUnderPrice(carsUnderPrice.getReferencePrice());
    }
}
