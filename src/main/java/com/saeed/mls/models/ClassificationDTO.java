package com.saeed.mls.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClassificationDTO {
    private String fileName;
    private String value;
    private double probability;
    private String type;

    public ClassificationDTO(Classification classification, String fileName) {
        this.fileName = fileName;
        this.value = classification.getClassName();
        this.probability = classification.getProbability();
        this.type = Type.getTypeFromString(value);
    }
}
