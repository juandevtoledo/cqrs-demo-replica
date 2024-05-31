package com.diplomado.receptor.infrastructure.drivenadapter.postgresql.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity(name = "transaction")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEntity {
    @Id
    private String id;
    private String status;
    private String inputMode;
    private String receipt;
    private String rrn;
    private String type;
    private BigDecimal amount;
}
