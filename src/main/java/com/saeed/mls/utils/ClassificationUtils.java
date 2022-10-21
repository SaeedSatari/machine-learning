package com.saeed.mls.utils;

import ai.djl.modality.Classifications;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.saeed.mls.models.Classification;
import com.saeed.mls.models.ClassificationResults;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public final class ClassificationUtils {
    private ClassificationUtils() {
    }

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static ClassificationResults convertClassifications(Classifications classifications) throws Exception {
        if (classifications != null) {
            log.debug("classifications.toJson()={}", classifications.toJson());
            return new ClassificationResults(objectMapper.readValue(classifications.toJson(), Classification[].class));
        }
        throw new NullPointerException("classifications cannot be null");
    }
}
