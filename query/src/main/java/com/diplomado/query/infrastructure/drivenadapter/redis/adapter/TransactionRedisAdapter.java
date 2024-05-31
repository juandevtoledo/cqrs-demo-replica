package com.diplomado.query.infrastructure.drivenadapter.redis.adapter;

import com.diplomado.query.domain.gateway.TransactionRedisGateway;
import com.diplomado.query.infrastructure.utils.ConversionUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class TransactionRedisAdapter implements TransactionRedisGateway {

    private final RedisTemplate<String, String> redisTemplate;

    @Override
    public List<Map<String, Object>> getAll(Class<?> clazz) {
        String hashKey = getHashFromClass(clazz);
        return redisTemplate.opsForHash()
                .values(hashKey)
                .stream()
                .map(el -> ConversionUtils.jsonString2Map(el.toString()))
                .toList();
    }

    private String getHashFromClass(Class<?> clazz) {
        String nameClass = clazz.getName();
        String[] partNameClass = nameClass.split("\\.");
        return partNameClass[partNameClass.length - 1];
    }

}
