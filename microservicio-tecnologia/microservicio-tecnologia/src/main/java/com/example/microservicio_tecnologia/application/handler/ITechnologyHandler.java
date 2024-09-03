package com.example.microservicio_tecnologia.application.handler;

import com.example.microservicio_tecnologia.application.dto.request.TechnologyRequestDto;

import java.util.List;

public interface ITechnologyHandler {

    void saveTechnology(TechnologyRequestDto technology);

    List<TechnologyRequestDto> getAllTechnologies();

    boolean existTechnologyByName(String name);

}
