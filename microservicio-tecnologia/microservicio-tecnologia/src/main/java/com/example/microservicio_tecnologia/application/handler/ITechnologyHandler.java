package com.example.microservicio_tecnologia.application.handler;

import com.example.microservicio_tecnologia.application.dto.request.TechnologyRequestDto;
import com.example.microservicio_tecnologia.application.dto.response.TechnologyResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface ITechnologyHandler {

    Mono<Void> saveTechnology(TechnologyRequestDto technology);

    Flux<TechnologyResponseDto> getAllTechnologies(int page, int size, String sortDirection);

    boolean existTechnologyByName(String name);

}
