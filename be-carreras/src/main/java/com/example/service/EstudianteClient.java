package com.example.service;

import com.example.config.RestTemplateConfig;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EstudianteClient {

    private final RestTemplateConfig restTemplate;

    @Value("${app.estudiante.url}:http://localhost:8081/api/estudiantes")
    private String url;

    //TODO: Implementar métodos


}
