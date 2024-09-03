package com.example.microservicio_tecnologia.infrastructure.mapper;

import com.example.microservicio_tecnologia.domain.model.TechnologyModel;
import com.example.microservicio_tecnologia.infrastructure.out.entity.TechnologyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import reactor.core.publisher.Flux;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ITechnologyEntityMapper {

    TechnologyEntity toEntity(TechnologyModel technologyModel);


    default Flux<TechnologyModel> toModel(Flux<TechnologyEntity> technologyEntityFlux) {
        return technologyEntityFlux.map(this::toModel);
    }
    TechnologyModel toModel(TechnologyEntity technologyEntity);

}
