package com.example.microservicio_tecnologia.factory;

import com.example.microservicio_tecnologia.domain.model.TechnologyModel;

public class TechnologyTestDataFactory {

    public static TechnologyModel getTechnologyModel() {
        TechnologyModel technologyModel = new TechnologyModel();
        technologyModel.setId(1L);
        technologyModel.setName("Java");
        technologyModel.setDescription("Lenjuaje de programación orientado a objetos");

        return technologyModel;
    }

    public static TechnologyModel getTechnologyModelWithLongName() {
        TechnologyModel technologyModel = new TechnologyModel();
        technologyModel.setId(1L);
        technologyModel.setName("ThisIsAVeryLongTechnologyNameThatExceedsTheMaximumAllowedLength");
        technologyModel.setDescription("Lenjuaje de programación orientado a objetos");

        return technologyModel;
    }

    public static TechnologyModel getTechnologyModelWithLongDescription() {
        TechnologyModel technologyModel = new TechnologyModel();
        technologyModel.setId(1L);
        technologyModel.setName("ValidTech");
        technologyModel.setDescription("This is a very long description that exceeds the maximum allowed length for descriptions in the system and should throw an exception");

        return technologyModel;
    }

}
