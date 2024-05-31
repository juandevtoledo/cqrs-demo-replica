package com.diplomado.queuelistener.application.usecase;

import com.diplomado.queuelistener.domain.gateway.TransactionRedisGateway;
import com.diplomado.queuelistener.domain.model.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@AllArgsConstructor
public class MessageBrokerUseCase {

    private final TransactionRedisGateway transactionGateway;

    public void create(Map<String, Object> reg) {
        transactionGateway.create(reg, Transaction.class);
    }


}
