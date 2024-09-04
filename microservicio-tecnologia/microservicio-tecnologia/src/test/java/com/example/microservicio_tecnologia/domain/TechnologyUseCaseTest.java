package com.example.microservicio_tecnologia.domain;


import com.example.microservicio_tecnologia.domain.exception.InvalidInputException;
import com.example.microservicio_tecnologia.domain.util.DomainConstants;
import com.example.microservicio_tecnologia.factory.TechnologyTestDataFactory;
import com.example.microservicio_tecnologia.domain.model.TechnologyModel;
import com.example.microservicio_tecnologia.domain.spi.ITechnologyPersistencePort;
import com.example.microservicio_tecnologia.domain.useCase.TechnologyUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

class TechnologyUseCaseTest {

    @Mock
    private ITechnologyPersistencePort technologyPersistencePort;

    @InjectMocks
    private TechnologyUseCase technologyUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveTechnologyAlreadyExists() {
        // Simular que la tecnología ya existe
        when(technologyPersistencePort.existTechnologyByName(anyString()))
                .thenReturn(Mono.just(true));

        TechnologyModel technologyModel = TechnologyTestDataFactory.getTechnologyModel();

        StepVerifier.create(technologyUseCase.saveTechnology(technologyModel))
                .expectErrorMatches(throwable -> throwable instanceof InvalidInputException &&
                        throwable.getMessage().equals(DomainConstants.TECHNOLOGY_ALREADY_EXISTS))
                .verify();

        verify(technologyPersistencePort).existTechnologyByName(technologyModel.getName());
    }

    @Test
    void testSaveTechnologyNameTooLong() {
        // Simular que la tecnología no existe
        when(technologyPersistencePort.existTechnologyByName(anyString()))
                .thenReturn(Mono.just(false));

        TechnologyModel technologyModel = TechnologyTestDataFactory.getTechnologyModelWithLongName();

        StepVerifier.create(technologyUseCase.saveTechnology(technologyModel))
                .expectErrorMatches(throwable -> throwable instanceof InvalidInputException &&
                        throwable.getMessage().equals(DomainConstants.TECHNOLOGY_NAME_TOO_LONG))
                .verify();

        verify(technologyPersistencePort).existTechnologyByName(technologyModel.getName());
    }

    @Test
    void testSaveTechnologyDescriptionTooLong() {
        // Simular que la tecnología no existe
        when(technologyPersistencePort.existTechnologyByName(anyString()))
                .thenReturn(Mono.just(false));

        TechnologyModel technologyModel = TechnologyTestDataFactory.getTechnologyModelWithLongDescription();

        StepVerifier.create(technologyUseCase.saveTechnology(technologyModel))
                .expectErrorMatches(throwable -> throwable instanceof InvalidInputException &&
                        throwable.getMessage().equals(DomainConstants.TECHNOLOGY_DESCRIPTION_TOO_LONG))
                .verify();

        verify(technologyPersistencePort).existTechnologyByName(technologyModel.getName());
    }

    @Test
    void testGetAllTechnologies() {
        List<TechnologyModel> technologyList = Arrays.asList(
                TechnologyTestDataFactory.getTechnologyModel(),
                TechnologyTestDataFactory.getTechnologyModel()
        );

        // Simular la obtención de todas las tecnologías
        when(technologyPersistencePort.getAllTechnologies(anyInt(), anyInt(), anyString()))
                .thenReturn(Flux.fromIterable(technologyList));

        StepVerifier.create(technologyUseCase.getAllTechnologies(0, 10, "asc"))
                .expectNextCount(2)
                .verifyComplete();

        verify(technologyPersistencePort).getAllTechnologies(0, 10, "asc");
    }
}

