package com.example.cqrsdemoreplica.persistence.database;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import lombok.Getter;

@Component
@Getter
public class InMemoryDB<K, T> implements InitializingBean {

    private Map<K, T> store;

    @Override
    public void afterPropertiesSet()  {
        store = new ConcurrentHashMap<>();
    }
}