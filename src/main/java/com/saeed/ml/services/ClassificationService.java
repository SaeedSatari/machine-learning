package com.saeed.ml.services;

import ai.djl.inference.Predictor;
import ai.djl.modality.Classifications;
import ai.djl.modality.cv.Image;
import ai.djl.modality.cv.ImageFactory;
import ai.djl.repository.zoo.Criteria;
import ai.djl.repository.zoo.ModelZoo;
import ai.djl.repository.zoo.ZooModel;
import com.saeed.ml.models.ClassificationResults;
import com.saeed.ml.models.dto.ClassificationDTO;
import com.saeed.ml.utils.ClassificationUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.InputStream;

@RequiredArgsConstructor
@Slf4j
@Service
public class ClassificationService {
    private final Criteria<Image, Classifications> criteria;

    public ClassificationDTO classifyImage(InputStream inputStream, String fileName) throws Exception {
        log.debug("Processing fileName={}", fileName);
        Image image = ImageFactory.getInstance().fromInputStream(inputStream);

        try (ZooModel<Image, Classifications> model = ModelZoo.loadModel(criteria);
             Predictor<Image, Classifications> predictor = model.newPredictor()) {
            Classifications classifications = predictor.predict(image);
            log.debug("classifications={}", classifications);

            ClassificationResults classificationResults = ClassificationUtils.convertClassifications(classifications);
            log.debug("classificationResults={}", classificationResults);

            ClassificationDTO classificationDTO = new ClassificationDTO(classificationResults.getBest(), fileName);
            log.info("classificationDTO={}", classificationDTO);
            return classificationDTO;
        }
    }
}


