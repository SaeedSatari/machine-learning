package com.saeed.ml.models.enums;

import java.util.stream.Stream;

public enum Type {
    CAT("cat"),
    DOG("dog"),
    ELEPHANT("elephant"),
    LION("lion"),
    UNKNOWN("unknown"),
    ZEBRA("zebra");

    private final String code;

    Type(String code) {
        this.code = code;
    }

    public static Type getTypeFromString(final String valueCode) {
        return Stream.of(Type.values()).filter(targetEnum -> valueCode.contains(targetEnum.code)).findFirst().orElse(UNKNOWN);
    }

}
