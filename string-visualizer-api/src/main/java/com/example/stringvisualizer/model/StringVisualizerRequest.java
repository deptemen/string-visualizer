package com.example.stringvisualizer.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;


@Data
public class StringVisualizerRequest {
    @NotBlank(message = "string1 must not be blank") String inputString1;

    @NotBlank(message = "string2 must not be blank") String inputString2;

}
