package com.diplomado.receptor.domain.model;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class Transaction {
    @NotNull
    private String status;
    @NotNull
    private String inputMode;
    @NotNull
    private String receipt;
    @NotNull
    private String rrn;
    @NotNull
    private String type;
    @NotNull
    private BigDecimal amount;
}
