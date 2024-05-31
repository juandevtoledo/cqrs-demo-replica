package com.diplomado.query.domain.gateway;

import java.util.List;
import java.util.Map;

public interface TransactionRedisGateway {

    List<Map<String, Object>> getAll(Class<?> clazz);
}
