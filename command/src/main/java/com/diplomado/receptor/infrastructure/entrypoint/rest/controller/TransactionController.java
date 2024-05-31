package com.diplomado.receptor.infrastructure.entrypoint.rest.controller;

import com.diplomado.receptor.application.usecase.TransactionUseCase;
import com.diplomado.receptor.domain.model.Transaction;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/transaction", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class TransactionController {

    private final TransactionUseCase transactionUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Transaction create(@Valid @RequestBody Transaction transaction) {
        return transactionUseCase.create(transaction);
    }

}
