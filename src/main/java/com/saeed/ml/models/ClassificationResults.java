package com.saeed.ml.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClassificationResults {
    private Classification[] classifications;

    public Classification getBest() {
        if (ArrayUtils.isNotEmpty(classifications)) {
            List<Classification> classificationList = Arrays.asList(classifications);
            return classificationList.stream().max(Comparator.comparing(Classification::getProbability))
                    .orElseThrow(NoSuchElementException::new);
        }
        return null;
    }
}
