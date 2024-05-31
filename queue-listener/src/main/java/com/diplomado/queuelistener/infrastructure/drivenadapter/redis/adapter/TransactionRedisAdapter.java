package com.diplomado.queuelistener.infrastructure.drivenadapter.redis.adapter;

import com.diplomado.queuelistener.domain.gateway.TransactionRedisGateway;
import com.diplomado.queuelistener.infrastructure.utils.ConversionUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@AllArgsConstructor
public class TransactionRedisAdapter implements TransactionRedisGateway {

    private final RedisTemplate<String, String> redisTemplate;

    @Override
    public void create(Map<String, Object> reg, Class<?> clazz) {
        try {
            redisTemplate.opsForHash().put(
                    getHashFromClass(clazz),
                    reg.get("id"),
                    ConversionUtils.map2JsonString(reg)
            );
        } catch (Exception e) {
            log.error("Error saving transaction: {}", e.getMessage());
        }

    }

    private String getHashFromClass(Class<?> clazz) {
        return clazz.getName().replace('.', '_');
    }

}
