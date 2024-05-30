package com.example.cqrsdemoreplica.persistence.replica;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.cqrsdemoreplica.persistence.database.DBSystem;
import com.example.cqrsdemoreplica.persistence.replica.dto.CarIdColorDTO;
import com.example.cqrsdemoreplica.persistence.replica.dto.CardBrandColorDTO;


@Repository
public class CarReadRepositoryImpl implements CarReadRepository {

    // Conexion simulada a la "replica", una base solo para lecturas

    private DBSystem dbSystem;

    public CarReadRepositoryImpl(final DBSystem dbSystem) {
        this.dbSystem = dbSystem;
    }

    // En un proyecto real estas queries son proyecciones, aprende mas https://youtu.be/64CjU6xNdx4
    @Override
    public List<CarIdColorDTO> findAllCarIdColorByBrand(String brand) {
       return this.dbSystem.getReplicaDb().getStore()
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .filter(c-> brand.equals(c.getBrand()))
                .map(m -> new CarIdColorDTO(m.getId(), m.getColor()))
                .collect(Collectors.toList());
    }

    @Override
    public List<CardBrandColorDTO> findAllCarBrandColorUnderPrice(BigDecimal referencePrice) {
       return this.dbSystem.getReplicaDb().getStore()
                .entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .filter(c-> referencePrice.compareTo(c.getPrice()) < 0)
                .map(m -> new CardBrandColorDTO(m.getBrand(), m.getColor()))
                .collect(Collectors.toList());
    }
}
