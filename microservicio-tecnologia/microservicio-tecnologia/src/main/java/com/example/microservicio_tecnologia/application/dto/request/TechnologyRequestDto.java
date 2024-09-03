package com.example.microservicio_tecnologia.application.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TechnologyRequestDto {

    @NotBlank
    @Max(value = 50 , message = "The name should be less than 50 characters")
    private String name;

    @NotBlank
    @Max(value = 90 , message = "The description should be less than 90 characters")
    private String description;

}
