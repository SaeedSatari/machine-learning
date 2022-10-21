package com.gitlab.johnjvester.mls.models;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Type {
    private Type() {
    }

    static List<String> cats = Arrays.asList("cat", "persian");
    static List<String> dogs = Arrays.asList("dog", "terrier", "labrador", "retriever", "appenzeller");
    static List<String> elephant = List.of("elephant");
    static List<String> lion = List.of("lion");
    static List<String> zebra = List.of("zebra");
    static List<String> types = Stream.of(cats, dogs, elephant, lion, zebra)
            .flatMap(Collection::stream)
            .collect(Collectors.toList());

    public static String getTypeFromString(final String valueCode) {
        for (String type : types)
            if (valueCode.toLowerCase().contains(type)) {
                if (cats.contains(type)) {
                    return "CAT";
                }
                if (dogs.contains(type)) {
                    return "DOG";
                }
                if (elephant.contains(type)) {
                    return "ELEPHANT";
                }
                if (lion.contains(type)) {
                    return "LION";
                }
                if (zebra.contains(type)) {
                    return "ZEBRA";
                }
            }
        return "UNKNOWN";
    }
}
