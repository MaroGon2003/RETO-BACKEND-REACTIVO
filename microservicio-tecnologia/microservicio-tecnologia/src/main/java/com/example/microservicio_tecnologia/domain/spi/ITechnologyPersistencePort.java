package com.example.microservicio_tecnologia.domain.spi;

import com.example.microservicio_tecnologia.domain.model.TechnologyModel;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ITechnologyPersistencePort {

    void saveTechnology(TechnologyModel technology);

    List<TechnologyModel> getAllTechnologies();

    Mono<Boolean> existTechnologyByName(String name);
}
