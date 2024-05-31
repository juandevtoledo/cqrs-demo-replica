package com.diplomado.receptor.infrastructure.drivenadapter.postgresql.repository;

import com.diplomado.receptor.infrastructure.drivenadapter.postgresql.entities.TransactionEntity;
import org.springframework.data.repository.CrudRepository;

public interface TransactionRepository extends CrudRepository<TransactionEntity, String> {

    boolean existsByReceiptAndRrn(String receipt, String rrn);
}
