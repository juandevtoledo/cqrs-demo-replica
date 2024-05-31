package com.diplomado.receptor.domain.config;

import lombok.Getter;

@Getter
public class SabanaException extends RuntimeException {

    private final ErrorCode error;

    public SabanaException(ErrorCode errorCode) {
        super(errorCode.getLog());
        this.error = errorCode;
    }

}
