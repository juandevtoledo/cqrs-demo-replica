package com.example.cqrsdemoreplica.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cqrsdemoreplica.persistence.replica.dto.CarIdColorDTO;
import com.example.cqrsdemoreplica.persistence.replica.dto.CardBrandColorDTO;
import com.example.cqrsdemoreplica.service.CarQueryService;
import com.example.cqrsdemoreplica.service.queries.CarsByBrand;
import com.example.cqrsdemoreplica.service.queries.CarsUnderPrice;

@RestController
@RequestMapping("/cars")
public class CarQueryController {

    private final CarQueryService carQueryService;

    public CarQueryController(CarQueryService carQueryService) {
        this.carQueryService = carQueryService;
    }

    @GetMapping("/brand/{brand}")
    public List<CarIdColorDTO> retrieveCardByBrandQuery(@PathVariable String brand) {
        return this.carQueryService
                .findAllCarIdColorByBrand(new CarsByBrand(brand));
    }

    @GetMapping("/price-under/{referencePrice}/")
    public List<CardBrandColorDTO> retrieveCardUnderPriceQuery(@PathVariable BigDecimal referencePrice) {
        return this.carQueryService
                .findAllCarBrandColorUnderPrice(new CarsUnderPrice(referencePrice));
    }
}
