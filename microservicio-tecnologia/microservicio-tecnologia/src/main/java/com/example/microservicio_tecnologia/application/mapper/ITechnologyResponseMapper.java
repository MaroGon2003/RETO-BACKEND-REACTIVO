package com.example.microservicio_tecnologia.application.mapper;

import com.example.microservicio_tecnologia.application.dto.response.TechnologyResponseDto;
import com.example.microservicio_tecnologia.domain.model.TechnologyModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ITechnologyResponseMapper {

    default Flux<TechnologyResponseDto> toTechnologyResponseDto(Flux<TechnologyModel> technologyModelFlux) {
        return technologyModelFlux.flatMap(technologyModel -> Mono.just(toTechnologyResponseDto(technologyModel)));
    }

    default Mono<TechnologyResponseDto> toTechnologyResponseDto(Mono<TechnologyModel> technologyModelMono) {
        return technologyModelMono.map(this::toTechnologyResponseDto);
    }

    TechnologyResponseDto toTechnologyResponseDto(TechnologyModel technologyModel);

}
