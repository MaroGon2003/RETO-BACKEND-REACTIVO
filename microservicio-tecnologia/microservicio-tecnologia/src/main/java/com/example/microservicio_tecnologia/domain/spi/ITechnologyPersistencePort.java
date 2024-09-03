package com.example.microservicio_tecnologia.domain.spi;

import com.example.microservicio_tecnologia.domain.model.TechnologyModel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ITechnologyPersistencePort {

    void saveTechnology(TechnologyModel technology);

    Flux<TechnologyModel> getAllTechnologies(int page, int size, String sortDirection);

    Mono<Boolean> existTechnologyByName(String name);
}
