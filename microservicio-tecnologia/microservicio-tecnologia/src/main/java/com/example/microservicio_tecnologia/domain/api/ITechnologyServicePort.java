package com.example.microservicio_tecnologia.domain.api;

import com.example.microservicio_tecnologia.domain.model.TechnologyModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITechnologyServicePort {

    Mono<Void> saveTechnology(TechnologyModel technology);

    Flux<TechnologyModel> getAllTechnologies(int page, int size, String sortDirection);

    Mono<Boolean> existTechnologyByName(String name);
}

