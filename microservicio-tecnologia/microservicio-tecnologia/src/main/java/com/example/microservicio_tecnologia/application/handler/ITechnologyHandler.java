package com.example.microservicio_tecnologia.application.handler;

import com.example.microservicio_tecnologia.application.dto.request.TechnologyRequestDto;
import com.example.microservicio_tecnologia.application.dto.response.TechnologyResponseDto;
import reactor.core.publisher.Flux;

import java.util.List;

public interface ITechnologyHandler {

    void saveTechnology(TechnologyRequestDto technology);

    Flux<TechnologyResponseDto> getAllTechnologies(int page, int size, String sortDirection);

    boolean existTechnologyByName(String name);

}
