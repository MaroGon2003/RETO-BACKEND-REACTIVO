package com.example.microservicio_tecnologia.infrastructure.out.adapter;

import com.example.microservicio_tecnologia.domain.model.TechnologyModel;
import com.example.microservicio_tecnologia.domain.spi.ITechnologyPersistencePort;
import com.example.microservicio_tecnologia.infrastructure.mapper.ITechnologyEntityMapper;
import com.example.microservicio_tecnologia.infrastructure.out.entity.TechnologyEntity;
import com.example.microservicio_tecnologia.infrastructure.out.repository.ITechnologyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
    public Flux<TechnologyModel> getAllTechnologies(int page, int size, String sortDirection) {
        Sort.Direction direction = Sort.Direction.fromString(sortDirection);
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, "name"));

        return technologyEntityMapper.toModel(technologyRepository.findAllBy(pageable));
    }

    @Override
    public Mono<Boolean> existTechnologyByName(String name) {
        return technologyRepository.existsByName(name);
    }
}
