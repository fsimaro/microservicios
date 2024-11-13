package com.example.controller;

import com.example.dto.EstudianteDto;
import com.example.service.EstudianteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final EstudianteService estudianteService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping()
    public Integer guardarEstudiante(@RequestBody EstudianteDto estudiante){
        return estudianteService.save(estudiante).getId();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<EstudianteDto> obtenerOrdenados(@RequestParam("property")String property){
        return estudianteService.findAllOrderBy(property);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/libreta/{libretaUniversitaria}")
    public Optional<EstudianteDto> findByLibretaUniversitaria(@PathVariable("libretaUniversitaria")String libretaUniversitaria){
        return estudianteService.findByLibretaUniversitaria(libretaUniversitaria);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<EstudianteDto> findByGenero(@RequestParam("genero")String genero){
        return estudianteService.findAllByGenero(genero);
    }

}
