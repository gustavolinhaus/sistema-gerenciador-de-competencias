package com.sgc.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.stream.Stream;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum Status {
    ACTIVE("Active"),
    INACTIVE("Inactive");

    private String value;

    public static String toValue(Status value) {
        if (value == null) {
            return null;
        }
        return value.getValue();
    }

    public static Status toEnum(String value) {
        if (value == null) {
            return null;
        }
        return Stream.of(Status.values())
                .filter(status -> status.getValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Could not find value " + value));
    }
}
