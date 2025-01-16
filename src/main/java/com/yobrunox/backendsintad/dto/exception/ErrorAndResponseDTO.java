package com.yobrunox.backendsintad.dto.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorAndResponseDTO<T> {
    private String code;
    private String message;
    private T body;
}