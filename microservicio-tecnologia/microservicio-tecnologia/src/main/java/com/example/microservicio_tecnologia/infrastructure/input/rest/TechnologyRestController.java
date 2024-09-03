package com.example.microservicio_tecnologia.infrastructure.input.rest;

import com.example.microservicio_tecnologia.application.dto.request.TechnologyRequestDto;
import com.example.microservicio_tecnologia.application.handler.ITechnologyHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/tecnologia")
@Slf4j
@RequiredArgsConstructor
public class TechnologyRestController {

    private final ITechnologyHandler technologyHandler;

    @PostMapping
    public Mono<String> save(@RequestBody TechnologyRequestDto technologyRequestDto) {
        technologyHandler.saveTechnology(technologyRequestDto);
        return Mono.just("Technology saved");
    }

}
