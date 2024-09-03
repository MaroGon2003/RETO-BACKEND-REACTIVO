package com.example.microservicio_tecnologia.infrastructure.mapper;

import com.example.microservicio_tecnologia.domain.model.TechnologyModel;
import com.example.microservicio_tecnologia.infrastructure.out.entity.TechnologyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ITechnologyEntityMapper {

    TechnologyEntity toEntity(TechnologyModel technologyModel);

}
