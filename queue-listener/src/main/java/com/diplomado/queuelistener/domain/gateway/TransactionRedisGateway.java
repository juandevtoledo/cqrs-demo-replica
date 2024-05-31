package com.diplomado.queuelistener.domain.gateway;

import java.util.Map;

public interface TransactionRedisGateway {
    void create(Map<String,Object> reg, Class<?> clazz );
}
