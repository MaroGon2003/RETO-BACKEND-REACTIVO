package com.example.microservicio_tecnologia.infrastructure.out.repository;

import com.example.microservicio_tecnologia.infrastructure.out.entity.TechnologyEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ITechnologyRepository extends ReactiveCrudRepository<TechnologyEntity, Long> {

    Mono<Boolean> existsByName(String name);

}
