package com.example.microservicio_tecnologia.domain.useCase;

import com.example.microservicio_tecnologia.domain.api.ITechnologyServicePort;
import com.example.microservicio_tecnologia.domain.exception.InvalidInputException;
import com.example.microservicio_tecnologia.domain.model.TechnologyModel;
import com.example.microservicio_tecnologia.domain.spi.ITechnologyPersistencePort;
import reactor.core.publisher.Mono;

import java.util.List;

public class TechhnologyUseCase implements ITechnologyServicePort {

    private final ITechnologyPersistencePort technologyPersistencePort;

    public TechhnologyUseCase(ITechnologyPersistencePort technologyPersistencePort) {
        this.technologyPersistencePort = technologyPersistencePort;
    }

    @Override
    public void saveTechnology(TechnologyModel technology) {

        if(Boolean.TRUE.equals(existTechnologyByName(technology.getName()).block())){
            throw new InvalidInputException("Technology already exists");
        }

        if(technology.getName().length() > 50){
            throw new InvalidInputException("Technology name is too long (max 50 characters)");
        }

        if (technology.getDescription().length() > 90){
            throw new InvalidInputException("Technology description is too long (max 90 characters)");
        }

        technologyPersistencePort.saveTechnology(technology);

    }

    @Override
    public List<TechnologyModel> getAllTechnologies() {
        return List.of();
    }

    @Override
    public Mono<Boolean> existTechnologyByName(String name) {
        return technologyPersistencePort.existTechnologyByName(name);
    }
}
