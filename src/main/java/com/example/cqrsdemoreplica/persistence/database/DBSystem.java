package com.example.cqrsdemoreplica.persistence.database;

import org.springframework.stereotype.Component;

import com.example.cqrsdemoreplica.persistence.model.Car;

@Component
public class DBSystem {
    private InMemoryDB<Long, Car> master;
    private InMemoryDB<Long, Car> replicaDb;

    public DBSystem(InMemoryDB<Long, Car> master, InMemoryDB<Long, Car> replicaDb) {

        this.master = master;
        this.replicaDb = replicaDb;
    }

    public void replicate(Car car){
        replicaDb.getStore().put(car.getId(),car);
    }

    public InMemoryDB<Long, Car> getMaster() {
        return master;
    }

    public InMemoryDB<Long, Car> getReplicaDb() {
        return replicaDb;
    }
}
