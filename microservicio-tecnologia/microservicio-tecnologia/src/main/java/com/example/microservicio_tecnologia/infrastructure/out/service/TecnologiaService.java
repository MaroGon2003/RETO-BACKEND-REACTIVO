package com.example.microservicio_tecnologia.infrastructure.out.service;

import com.example.microservicio_tecnologia.infrastructure.out.entity.TecnologiaEntity;
import com.example.microservicio_tecnologia.infrastructure.out.repository.ITecnologiaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
@RequiredArgsConstructor
public class TecnologiaService {

    private final ITecnologiaRepository tecnologiaRepository;

    public Mono<TecnologiaEntity> saveTecnologia(TecnologiaEntity tecnologiaEntity) {
        return tecnologiaRepository.save(tecnologiaEntity);
    }

    public Flux<TecnologiaEntity> getAllTecnologias() {
        return tecnologiaRepository.findAll();
    }

}
