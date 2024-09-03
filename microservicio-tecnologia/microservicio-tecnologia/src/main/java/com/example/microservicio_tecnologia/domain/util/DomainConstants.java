package com.example.microservicio_tecnologia.domain.util;

public class DomainConstants {

    private DomainConstants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String TECHNOLOGY_ALREADY_EXISTS = "Technology already exists";
    public static final String TECHNOLOGY_NAME_TOO_LONG = "Technology name is too long (max 50 characters)";
    public static final String TECHNOLOGY_DESCRIPTION_TOO_LONG = "Technology description is too long (max 90 characters)";

}
