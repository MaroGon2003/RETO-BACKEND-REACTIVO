package com.example.microservicio_tecnologia.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TechnologyResponseDto {

    private Long id;
    private String name;
    private String description;

}
