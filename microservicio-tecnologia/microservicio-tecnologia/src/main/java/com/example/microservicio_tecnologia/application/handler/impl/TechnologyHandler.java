package com.example.microservicio_tecnologia.application.handler.impl;

import com.example.microservicio_tecnologia.application.dto.request.TechnologyRequestDto;
import com.example.microservicio_tecnologia.application.dto.response.TechnologyResponseDto;
import com.example.microservicio_tecnologia.application.handler.ITechnologyHandler;
import com.example.microservicio_tecnologia.application.mapper.ITechnologyRequestMapper;
import com.example.microservicio_tecnologia.application.mapper.ITechnologyResponseMapper;
import com.example.microservicio_tecnologia.domain.api.ITechnologyServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TechnologyHandler implements ITechnologyHandler {

    private final ITechnologyServicePort technologyServicePort;
    private final ITechnologyRequestMapper technologyRequestMapper;
    private final ITechnologyResponseMapper technologyResponseMapper;

    @Override
    public void saveTechnology(TechnologyRequestDto technology) {

        technologyServicePort.saveTechnology(technologyRequestMapper.toTechnologyModel(technology));

    }

    @Override
    public Flux<TechnologyResponseDto> getAllTechnologies(int page, int size, String sortDirection) {
        return technologyResponseMapper.toTechnologyResponseDto(technologyServicePort.getAllTechnologies(page, size, sortDirection));
    }

    @Override
    public boolean existTechnologyByName(String name) {
        return false;
    }
}
