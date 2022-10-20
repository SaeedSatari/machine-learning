package com.saeed.ml.controllers;

import com.saeed.ml.models.dto.ClassificationDTO;
import com.saeed.ml.services.ClassificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Slf4j
@CrossOrigin
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
public class ClassificationController {
    private final ClassificationService classificationService;

    @PostMapping(value = "/classify")
    public ResponseEntity<ClassificationDTO> classifyImage(@RequestParam("file") MultipartFile file) {
        try {
            return new ResponseEntity<>(classificationService.classifyImage(file.getInputStream(), file.getOriginalFilename()), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            log.error("There is an issue with file={}, message={}", file.getName(), e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

