package com.diplomado.query.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class Transaction {
    private String id;
    private String status;
    private String inputMode;
    private String receipt;
    private String rrn;
    private String type;
    private BigDecimal amount;
}
