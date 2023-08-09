package com.example.stringvisualizer.controller;

import com.example.stringvisualizer.model.StringVisualizerRequest;
import com.example.stringvisualizer.service.StringVisualizerService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin
public class StringVisualizerController {
    private final StringVisualizerService stringVisualizerService;

    @Autowired
    public StringVisualizerController(StringVisualizerService stringVisualizerService) {
        this.stringVisualizerService = stringVisualizerService;
    }

    @PostMapping("/visualize-max-occurrence")
    @Operation(summary = "Compare strings based on maximum occurrences", description = "Compares two input strings based on the maximum occurrences of lowercase letters.")
    public ResponseEntity<String> visualizeMaxOccurrence(@RequestBody @Valid StringVisualizerRequest request) {
        return ResponseEntity.ok().body(stringVisualizerService.computeMaxLetterOccurrence(request.getInputString1(), request.getInputString2()));
    }
}
