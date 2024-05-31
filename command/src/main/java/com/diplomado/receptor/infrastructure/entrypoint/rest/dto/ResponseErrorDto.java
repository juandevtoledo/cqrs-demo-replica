package com.diplomado.receptor.infrastructure.entrypoint.rest.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ResponseErrorDto {
    private String code;
    private String message;
}
