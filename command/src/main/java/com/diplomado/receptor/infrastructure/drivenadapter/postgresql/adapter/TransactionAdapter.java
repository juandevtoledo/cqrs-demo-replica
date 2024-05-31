package com.diplomado.receptor.infrastructure.drivenadapter.postgresql.adapter;

import com.diplomado.receptor.domain.gateway.TransactionGateway;
import com.diplomado.receptor.domain.model.Transaction;
import com.diplomado.receptor.infrastructure.drivenadapter.postgresql.entities.TransactionEntity;
import com.diplomado.receptor.infrastructure.drivenadapter.postgresql.mapper.TransactionMapper;
import com.diplomado.receptor.infrastructure.drivenadapter.postgresql.repository.TransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TransactionAdapter implements TransactionGateway {

    private final TransactionRepository transactionRepository;

    @Override
    public Transaction create(Transaction transaction) {
        TransactionEntity transactionEntity = transactionRepository.save(TransactionMapper.toEntity(transaction));
        return TransactionMapper.toDomain(transactionEntity);
    }

    @Override
    public boolean existsByReceiptAndRrn(String receipt, String rnn) {
        return transactionRepository.existsByReceiptAndRrn(receipt, rnn);
    }

}
