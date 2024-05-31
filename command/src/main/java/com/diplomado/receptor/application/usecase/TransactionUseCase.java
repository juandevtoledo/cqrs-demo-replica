package com.diplomado.receptor.application.usecase;

import com.diplomado.receptor.domain.config.ErrorCode;
import com.diplomado.receptor.domain.config.SabanaException;
import com.diplomado.receptor.domain.gateway.TransactionGateway;
import com.diplomado.receptor.domain.model.Transaction;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class TransactionUseCase {

    private final TransactionGateway transactionGateway;

    public Transaction create(Transaction transaction) {
        boolean existsTransaction = transactionGateway.existsByReceiptAndRrn(transaction.getReceipt(), transaction.getRrn());
        if (existsTransaction) {
            throw new SabanaException(ErrorCode.B422000);
        }
        return transactionGateway.create(transaction);
    }

}
