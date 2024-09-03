package com.example.microservicio_tecnologia.infrastructure.input.rest;

import com.example.microservicio_tecnologia.application.dto.request.TechnologyRequestDto;
import com.example.microservicio_tecnologia.application.dto.response.TechnologyResponseDto;
import com.example.microservicio_tecnologia.application.handler.ITechnologyHandler;
import com.example.microservicio_tecnologia.infrastructure.InfrastructureConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
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
        return Mono.just(InfrastructureConstants.TECHNOLOGY_CREATED);
    }

    @GetMapping
    public Flux<TechnologyResponseDto> getAll(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "10") int size,
                                              @RequestParam(defaultValue = "asc") String sortDirection) {
        return technologyHandler.getAllTechnologies(page, size, sortDirection);
    }

}
