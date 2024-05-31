package com.diplomado.query.infrastructure.entrypoint.rest.controller;

import com.diplomado.query.domain.config.ErrorCode;
import com.diplomado.query.domain.config.ErrorDictionary;
import com.diplomado.query.domain.config.SabanaException;
import com.diplomado.query.infrastructure.entrypoint.rest.dto.ResponseErrorDto;
import com.diplomado.query.infrastructure.entrypoint.rest.mapper.ErrorResponseMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseErrorDto> handleConstraintViolationException(MethodArgumentNotValidException e) {
        return genericHandleException(ErrorCode.B400000);
    }

    @ExceptionHandler(SabanaException.class)
    public ResponseEntity<ResponseErrorDto> handlePragmaException(SabanaException e) {
        return genericHandleException(e.getError());
    }

    private ResponseEntity<ResponseErrorDto> genericHandleException(ErrorCode errorCode) {
        ErrorDictionary errorDictionary = ErrorDictionary.builder()
                .id(errorCode.getCode())
                .message(errorCode.getLog())
                .httpStatus(errorCode.getStatus())
                .build();

        ResponseErrorDto responseErrorDto = ErrorResponseMapper.toResponseErrorDto(errorDictionary);

        return ResponseEntity
                .status(Objects.requireNonNull(HttpStatus.resolve(errorDictionary.getHttpStatus())))
                .body(responseErrorDto);
    }

}
