package org.example.dto;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class SensorDTO {
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 30, message = "Name must be between 3 and 30 characters")
    private String name;

    @NotBlank(message = "Model is required")
    @Size(max = 15, message = "Model must not exceed 15 characters")
    private String model;

    @NotNull(message = "Range from is required")
    @Min(value = 0, message = "Range from must be positive")
    private Integer rangeFrom;

    @NotNull(message = "Range to is required")
    @Min(value = 0, message = "Range to must be positive")
    private Integer rangeTo;

    @NotNull(message = "Type is required")
    private String type;

    private String unit;

    @Size(max = 40, message = "Location must not exceed 40 characters")
    private String location;

    @Size(max = 200, message = "Description must not exceed 200 characters")
    private String description;
} 