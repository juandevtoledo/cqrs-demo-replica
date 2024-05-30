package com.example.cqrsdemoreplica.persistence.master;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.cqrsdemoreplica.persistence.database.DBSystem;
import com.example.cqrsdemoreplica.persistence.model.Car;


@Repository
public class CarWriteRepositoryImpl implements CarWriteRepository {

    public DBSystem dbSystem;

    public CarWriteRepositoryImpl(final DBSystem dbSystem) {
        this.dbSystem = dbSystem;
    }

    @Override
    public void save(Car car) {
        this.dbSystem.getMaster().getStore().put(car.getId(), car);
        //Replicate informtion to READ system
        this.dbSystem.replicate(car);
    }

    @Override
    public void update(Car car) {
        this.save(car);
    }

    @Override
    public Optional<Car> findById(Long id) {
        return Optional.ofNullable(this.dbSystem.getMaster().getStore().get(id));
    }
}