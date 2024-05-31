package com.example.cqrsdemoreplica.persistence.database;

import org.springframework.stereotype.Component;

import lombok.Getter;

import com.example.cqrsdemoreplica.persistence.model.Car;

@Getter
@Component
public class DBSystem<T> {
    private InMemoryDB<Long, T> master;
    private InMemoryDB<Long, T> replicaDb;

    public DBSystem(InMemoryDB<Long, T> master, InMemoryDB<Long, T> replicaDb) {

        this.master = master;
        this.replicaDb = replicaDb;
    }

    public void replicate(Long id,T dto){
        replicaDb.getStore().put(id,dto);
    }

}
