package com.example.microservicio_tecnologia.infrastructure.out.adapter;

import com.example.microservicio_tecnologia.domain.model.TechnologyModel;
import com.example.microservicio_tecnologia.domain.spi.ITechnologyPersistencePort;
import com.example.microservicio_tecnologia.infrastructure.mapper.ITechnologyEntityMapper;
import com.example.microservicio_tecnologia.infrastructure.out.entity.TechnologyEntity;
import com.example.microservicio_tecnologia.infrastructure.out.repository.ITechnologyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TechnologyReactiveCrudAdapter implements ITechnologyPersistencePort {

    private final ITechnologyRepository technologyRepository;
    private final ITechnologyEntityMapper technologyEntityMapper;

    @Override
    public void saveTechnology(TechnologyModel technology) {
        TechnologyEntity technologyEntity = technologyEntityMapper.toEntity(technology);
        technologyRepository.save(technologyEntity).subscribe();
    }

    @Override
    public List<TechnologyModel> getAllTechnologies() {
        return List.of();
    }

    @Override
    public Mono<Boolean> existTechnologyByName(String name) {
        return technologyRepository.existsByName(name);
    }
}
