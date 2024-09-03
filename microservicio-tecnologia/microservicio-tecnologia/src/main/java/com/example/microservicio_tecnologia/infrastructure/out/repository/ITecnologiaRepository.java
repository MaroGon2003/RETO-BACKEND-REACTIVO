package com.example.microservicio_tecnologia.infrastructure.out.repository;

import com.example.microservicio_tecnologia.infrastructure.out.entity.TecnologiaEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITecnologiaRepository extends ReactiveCrudRepository<TecnologiaEntity, Long> {
}
