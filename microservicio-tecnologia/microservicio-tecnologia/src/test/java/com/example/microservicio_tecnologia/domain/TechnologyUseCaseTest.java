package com.example.microservicio_tecnologia.domain;


import com.example.microservicio_tecnologia.domain.exception.InvalidInputException;
import com.example.microservicio_tecnologia.factory.TechnologyTestDataFactory;
import com.example.microservicio_tecnologia.domain.model.TechnologyModel;
import com.example.microservicio_tecnologia.domain.spi.ITechnologyPersistencePort;
import com.example.microservicio_tecnologia.domain.useCase.TechnologyUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;

import static org.junit.jupiter.api.Assertions.assertThrows;
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
    void saveTechnology_shouldThrowException_whenTechnologyAlreadyExists() {
        // Given
        TechnologyModel technologyModel = TechnologyTestDataFactory.getTechnologyModel();
        when(technologyPersistencePort.existTechnologyByName(anyString())).thenReturn(Mono.just(true));

        // When & Then
        assertThrows(InvalidInputException.class, () -> technologyUseCase.saveTechnology(technologyModel));
        verify(technologyPersistencePort, never()).saveTechnology(any());
    }

    @Test
    void saveTechnology_shouldThrowException_whenTechnologyNameTooLong() {
        // Given
        TechnologyModel technologyModel = TechnologyTestDataFactory.getTechnologyModelWithLongName();
        when(technologyPersistencePort.existTechnologyByName(anyString())).thenReturn(Mono.just(false));

        // When & Then
        assertThrows(InvalidInputException.class, () -> technologyUseCase.saveTechnology(technologyModel));
        verify(technologyPersistencePort, never()).saveTechnology(any());
    }

    @Test
    void saveTechnology_shouldThrowException_whenTechnologyDescriptionTooLong() {
        // Given
        TechnologyModel technologyModel = TechnologyTestDataFactory.getTechnologyModelWithLongDescription();
        when(technologyPersistencePort.existTechnologyByName(anyString())).thenReturn(Mono.just(false));

        // When & Then
        assertThrows(InvalidInputException.class, () -> technologyUseCase.saveTechnology(technologyModel));
        verify(technologyPersistencePort, never()).saveTechnology(any());
    }

    @Test
    void saveTechnology_shouldSaveTechnology_whenValidTechnology() {
        // Given
        TechnologyModel technologyModel = TechnologyTestDataFactory.getTechnologyModel();
        when(technologyPersistencePort.existTechnologyByName("Java")).thenReturn(Mono.just(false));

        // When
        technologyUseCase.saveTechnology(technologyModel);

        // Then
        verify(technologyPersistencePort, times(1)).saveTechnology(technologyModel);
    }
}

