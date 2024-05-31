package com.diplomado.receptor.domain.gateway;

import com.diplomado.receptor.domain.model.Transaction;

public interface TransactionGateway {
    Transaction create(Transaction transaction);
    boolean existsByReceiptAndRrn(String receipt, String rnn);
}
