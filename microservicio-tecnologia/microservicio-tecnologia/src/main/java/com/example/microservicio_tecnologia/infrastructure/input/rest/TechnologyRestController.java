package com.example.microservicio_tecnologia.infrastructure.input.rest;

import com.example.microservicio_tecnologia.application.dto.request.TechnologyRequestDto;
import com.example.microservicio_tecnologia.application.dto.response.TechnologyResponseDto;
import com.example.microservicio_tecnologia.application.handler.ITechnologyHandler;
import com.example.microservicio_tecnologia.domain.exception.InvalidInputException;
import com.example.microservicio_tecnologia.infrastructure.InfrastructureConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Mono<ResponseEntity<String>> save(@RequestBody TechnologyRequestDto technologyRequestDto) {
        return technologyHandler.saveTechnology(technologyRequestDto)
                .thenReturn(ResponseEntity.status(HttpStatus.CREATED)
                        .body(InfrastructureConstants.TECHNOLOGY_CREATED))
                .onErrorResume(InvalidInputException.class, ex ->
                        Mono.just(ResponseEntity.badRequest().body(ex.getMessage()))
                )
                .onErrorResume(Exception.class, ex ->
                        Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(InfrastructureConstants.INTERNAL_SERVER_ERROR))
                );
    }

    @GetMapping
    public Flux<TechnologyResponseDto> getAll(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "10") int size,
                                              @RequestParam(defaultValue = "asc") String sortDirection) {
        return technologyHandler.getAllTechnologies(page, size, sortDirection);
    }

}
