package com.example.microservicio_tecnologia.domain.useCase;

import com.example.microservicio_tecnologia.domain.api.ITechnologyServicePort;
import com.example.microservicio_tecnologia.domain.exception.InvalidInputException;
import com.example.microservicio_tecnologia.domain.model.TechnologyModel;
import com.example.microservicio_tecnologia.domain.spi.ITechnologyPersistencePort;
import com.example.microservicio_tecnologia.domain.util.DomainConstants;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class TechnologyUseCase implements ITechnologyServicePort {

    private final ITechnologyPersistencePort technologyPersistencePort;

    public TechnologyUseCase(ITechnologyPersistencePort technologyPersistencePort) {
        this.technologyPersistencePort = technologyPersistencePort;
    }

    @Override
    public void saveTechnology(TechnologyModel technology) {

        if(Boolean.TRUE.equals(existTechnologyByName(technology.getName()).block())){
            throw new InvalidInputException(DomainConstants.TECHNOLOGY_ALREADY_EXISTS);
        }

        if(technology.getName().length() > 50){
            throw new InvalidInputException(DomainConstants.TECHNOLOGY_NAME_TOO_LONG);
        }

        if (technology.getDescription().length() > 90){
            throw new InvalidInputException(DomainConstants.TECHNOLOGY_DESCRIPTION_TOO_LONG);
        }

        technologyPersistencePort.saveTechnology(technology);

    }

    @Override
    public Flux<TechnologyModel> getAllTechnologies(int page, int size, String sortDirection) {
        return technologyPersistencePort.getAllTechnologies(page, size, sortDirection);
    }

    @Override
    public Mono<Boolean> existTechnologyByName(String name) {
        return technologyPersistencePort.existTechnologyByName(name);
    }
}
