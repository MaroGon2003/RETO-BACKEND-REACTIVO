package com.example.microservicio_tecnologia.infra;

import com.example.microservicio_tecnologia.application.dto.request.TechnologyRequestDto;
import com.example.microservicio_tecnologia.application.dto.response.TechnologyResponseDto;
import com.example.microservicio_tecnologia.application.handler.ITechnologyHandler;
import com.example.microservicio_tecnologia.domain.model.TechnologyModel;
import com.example.microservicio_tecnologia.factory.TechnologyTestDataFactory;
import com.example.microservicio_tecnologia.infrastructure.InfrastructureConstants;
import com.example.microservicio_tecnologia.infrastructure.input.rest.TechnologyRestController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@WebFluxTest(controllers = TechnologyRestController.class)
public class TechnologyRestControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private ITechnologyHandler technologyHandler;

    private TechnologyRequestDto technologyRequestDto;
    private TechnologyResponseDto technologyResponseDto;

    @BeforeEach
    void setUp() {
        technologyRequestDto = new TechnologyRequestDto();
        TechnologyModel technologyModel = TechnologyTestDataFactory.getTechnologyModel();
        technologyRequestDto.setName(technologyModel.getName());
        technologyRequestDto.setDescription(technologyModel.getDescription());

        technologyResponseDto = new TechnologyResponseDto();
        technologyResponseDto.setName(technologyModel.getName());
        technologyResponseDto.setDescription(technologyModel.getDescription());
    }

    @Test
    void testSaveTechnology() {
        doNothing().when(technologyHandler).saveTechnology(any(TechnologyRequestDto.class));

        webTestClient.post()
                .uri("/tecnologia")
                .bodyValue(technologyRequestDto)
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class).isEqualTo(InfrastructureConstants.TECHNOLOGY_CREATED);

        verify(technologyHandler).saveTechnology(any(TechnologyRequestDto.class));
    }

    @Test
    void testGetAllTechnologies() {
        when(technologyHandler.getAllTechnologies(0, 10, "asc")).thenReturn(Flux.just(technologyResponseDto));

        webTestClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/tecnologia")
                        .queryParam("page", 0)
                        .queryParam("size", 10)
                        .queryParam("sortDirection", "asc")
                        .build())
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(TechnologyResponseDto.class)
                .hasSize(1)
                .contains(technologyResponseDto);

        verify(technologyHandler).getAllTechnologies(0, 10, "asc");
    }
}

