package com.saeed.ml.models.dto;

import com.saeed.ml.models.Classification;
import com.saeed.ml.models.enums.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClassificationDTO {
    private String fileName;
    private String value;
    private double probability;
    private Type type;

    public ClassificationDTO(Classification classification, String fileName) {
        this.fileName = fileName;
        this.value = classification.getClassName();
        this.probability = classification.getProbability();
        this.type = Type.getTypeFromString(value);
    }
}
