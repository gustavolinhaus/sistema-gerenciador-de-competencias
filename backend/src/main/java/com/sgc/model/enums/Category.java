package com.sgc.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.stream.Stream;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum Category {

    BACK_END("Back-end"),
    FRONT_END("Front-end"),
    DATABASE("Database"),
    ARCHITECTURE("Architecture"),
    AGILE_METHODOLOGY("Agile methodology"),
    TESTS("Tests"),
    LEADERSHIP("Leadership"),
    DEVOPS("Devops");

    private String value;

    public static String toValue(Category value) {
        if (value == null) {
            return null;
        }
        return value.getValue();
    }

    public static Category toEnum(String value) {
        if (value == null) {
            return null;
        }
        return Stream.of(Category.values())
                .filter(category -> category.getValue().equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Could not find value " + value));
    }
}
