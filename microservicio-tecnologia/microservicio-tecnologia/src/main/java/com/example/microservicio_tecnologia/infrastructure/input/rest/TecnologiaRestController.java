package com.example.microservicio_tecnologia.infrastructure.input.rest;

import com.example.microservicio_tecnologia.infrastructure.out.entity.TecnologiaEntity;
import com.example.microservicio_tecnologia.infrastructure.out.service.TecnologiaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/tecnologia")
@Slf4j
@RequiredArgsConstructor
public class TecnologiaRestController {

    private final TecnologiaService tecnologiaService;

    @PostMapping
    public Mono<TecnologiaEntity> save(@RequestBody TecnologiaEntity tecnologiaEntity) {
        return tecnologiaService.saveTecnologia(tecnologiaEntity);
    }

    @GetMapping
    public Flux<TecnologiaEntity> getAll() {
        return tecnologiaService.getAllTecnologias();
    }

}
