package com.example.microservicio_tecnologia.infrastructure.out.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("tecnologias")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TechnologyEntity {

    @Id
    private Long id;
    private String name;
    private String description;

}
