package com.example.microservicio_tecnologia.domain.api;

import com.example.microservicio_tecnologia.domain.model.TechnologyModel;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ITechnologyServicePort {

    void saveTechnology(TechnologyModel technology);

    List<TechnologyModel> getAllTechnologies();

    Mono<Boolean> existTechnologyByName(String name);
}

