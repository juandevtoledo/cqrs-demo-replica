package com.example.cqrsdemoreplica.persistence.master;

import java.util.Optional;

import com.example.cqrsdemoreplica.persistence.model.Car;

public interface CarWriteRepository {
    void save(Car car);
    void update(Car car);
    Optional<Car> findById(Long id);

}
