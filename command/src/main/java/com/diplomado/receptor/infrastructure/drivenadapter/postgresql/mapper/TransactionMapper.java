package com.diplomado.receptor.infrastructure.drivenadapter.postgresql.mapper;

import com.diplomado.receptor.domain.model.Transaction;
import com.diplomado.receptor.infrastructure.drivenadapter.postgresql.entities.TransactionEntity;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class TransactionMapper {

    public static TransactionEntity toEntity(Transaction transaction) {
        return TransactionEntity.builder()
                .id(UUID.randomUUID().toString())
                .type(transaction.getType())
                .rrn(transaction.getRrn())
                .receipt(transaction.getReceipt())
                .status(transaction.getStatus())
                .inputMode(transaction.getInputMode())
                .amount(transaction.getAmount())
                .build();
    }

    public static Transaction toDomain(TransactionEntity transactionEntity) {
        return Transaction.builder()
                .type(transactionEntity.getType())
                .rrn(transactionEntity.getRrn())
                .receipt(transactionEntity.getReceipt())
                .status(transactionEntity.getStatus())
                .inputMode(transactionEntity.getInputMode())
                .build();
    }

}
