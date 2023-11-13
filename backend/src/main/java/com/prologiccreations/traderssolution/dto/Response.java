package com.prologiccreations.traderssolution.dto;

import com.prologiccreations.traderssolution.constants.enums.OperationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Response<D> {
    private OperationStatus status;
    private String message;
    private D data;
}
