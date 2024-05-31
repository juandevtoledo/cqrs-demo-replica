package com.diplomado.query.application.usecase;

import com.diplomado.query.domain.gateway.TransactionRedisGateway;
import com.diplomado.query.domain.model.Transaction;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Component
public class TransactionUseCase {

    private final TransactionRedisGateway transactionGateway;

    public List<Map<String, Object>> getAll() {
        return transactionGateway.getAll(Transaction.class);
    }

}
