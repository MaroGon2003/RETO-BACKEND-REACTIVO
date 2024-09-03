package com.example.microservicio_tecnologia.application.mapper;

import com.example.microservicio_tecnologia.application.dto.request.TechnologyRequestDto;
import com.example.microservicio_tecnologia.domain.model.TechnologyModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ITechnologyRequestMapper {

    TechnologyModel toTechnologyModel(TechnologyRequestDto technologyRequestDto);

}
