package com.diplomado.query.infrastructure.entrypoint.rest.mapper;

import com.diplomado.query.domain.config.ErrorDictionary;
import com.diplomado.query.infrastructure.entrypoint.rest.dto.ResponseErrorDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ErrorResponseMapper {

    public static ResponseErrorDto toResponseErrorDto(ErrorDictionary errorDictionary) {
        return ResponseErrorDto.builder()
                .code(errorDictionary.getId())
                .message(errorDictionary.getMessage())
                .build();
    }

}
