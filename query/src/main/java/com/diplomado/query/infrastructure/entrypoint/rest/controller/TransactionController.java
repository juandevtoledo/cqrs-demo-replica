package com.diplomado.query.infrastructure.entrypoint.rest.controller;

import com.diplomado.query.application.usecase.TransactionUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/transaction", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class TransactionController {

    private final TransactionUseCase transactionUseCase;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Map<String, Object>> getAll() {
        return transactionUseCase.getAll();
    }

}
