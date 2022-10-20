package com.saeed.ml.configs;

import ai.djl.Application;
import ai.djl.modality.Classifications;
import ai.djl.modality.cv.Image;
import ai.djl.modality.cv.transform.Resize;
import ai.djl.modality.cv.transform.ToTensor;
import ai.djl.modality.cv.translator.ImageClassificationTranslator;
import ai.djl.repository.zoo.Criteria;
import ai.djl.training.util.ProgressBar;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CriteriaConfig {
    private static final int RESIZE_WIDTH = 224;
    private static final int RESIZE_HEIGHT = 224;
    private static final String DEFAULT_LAYERS_KEY = "layers";
    private static final String DEFAULT_LAYERS_VALUE_STRING = "50";

    @Bean
    public Criteria<Image, Classifications> criteria() {
        log.info("Establishing Criteria<Image, Classifications>");

        ImageClassificationTranslator translator = ImageClassificationTranslator.builder()
                .addTransform(new Resize(RESIZE_WIDTH, RESIZE_HEIGHT))
                .addTransform(new ToTensor())
                .build();

        Criteria<Image, Classifications> criteria = Criteria.builder()
                .setTypes(Image.class, Classifications.class)
                .optApplication(Application.CV.IMAGE_CLASSIFICATION)
                .optFilter(DEFAULT_LAYERS_KEY, DEFAULT_LAYERS_VALUE_STRING)
                .optTranslator(translator)
                .optProgress(new ProgressBar())
                .build();

        log.info("Service will utilize criteria={}", criteria);
        return criteria;
    }
}

