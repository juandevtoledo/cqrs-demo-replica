package com.diplomado.receptor.domain.config;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorDictionary {
    private String id;
    private String message;
    private Integer httpStatus;
}
