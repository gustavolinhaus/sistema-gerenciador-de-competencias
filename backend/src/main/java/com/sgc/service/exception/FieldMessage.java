package com.sgc.service.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FieldMessage {
    private String fieldName;
    private String message;
}