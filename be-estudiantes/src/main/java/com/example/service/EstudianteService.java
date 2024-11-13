package com.example.service;

import com.example.dto.EstudianteDto;
import com.example.model.Estudiante;
import com.example.repository.EstudianteRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EstudianteService {

    private final EstudianteRepository estudianteRepository;

    /**
     * Crea o modifica el estudiante enviado por parametro
     */
    public EstudianteDto save(EstudianteDto dto){
        System.out.println("Guardando el estudiante: " + dto.toString());
        Estudiante entidad = mapToEntity(dto);
        dto.setId(estudianteRepository.save(entidad).getId());
        System.out.println("Estudiante guardado con id " + entidad.getId());
        return dto;
    }

    /**
     * Imprime el resultado de llamar al método findAllByGenero de {@code EstudianteRepository}
     */
    public List<EstudianteDto> findAllByGenero(String genero){
        System.out.println("Obteniendo estudiantes con genero: " + genero);
        List<EstudianteDto> estudiantes = estudianteRepository.findAllByGenero(genero).stream().map(this::mapToDto).collect(Collectors.toList());
        for(EstudianteDto e : estudiantes) System.out.println(e.toString());
        return estudiantes;
    }

    /**
     * Imprime el resultado de llamar al método findAllOrderBY de {@code EstudianteRepository}
     */
    public List<EstudianteDto> findAllOrderBy(String property){
        System.out.println("Obteniendo estudiantes ordenados por:  " + property);
        Sort sort = Sort.by(property);
        List<EstudianteDto> estudiantes = estudianteRepository.findAll(sort).stream().map(this::mapToDto).collect(Collectors.toList());
        for(EstudianteDto e : estudiantes) System.out.println(e.toString());
        return estudiantes;
    }

    /**
     * Imprime el resultado de llamar al método findByLibretaUniversitaria de {@code EstudianteRepository}
     */
    public Optional<EstudianteDto> findByLibretaUniversitaria(String libretaUniversitaria){
        System.out.println("Buscando estudiante con libreta universitaria: " + libretaUniversitaria);
        Optional<EstudianteDto> estudiante = estudianteRepository.findByLibretaUniversitaria(libretaUniversitaria).map(this::mapToDto);
        if (estudiante.isPresent()) {
            System.out.println(estudiante.get());
        } else {
            System.out.println("No se ha encontrado un estudiante con libreta " + libretaUniversitaria);
        }
        return estudiante;
    }

    private Estudiante mapToEntity(EstudianteDto dto){
        Estudiante result = new Estudiante();
        result.setId(dto.getId());
        result.setNombre(dto.getNombre());
        result.setApellido(dto.getApellido());
        result.setGenero(dto.getGenero());
        result.setCiudadOrigen(dto.getCiudadOrigen());
        result.setFechaNacimiento(dto.getFechaNacimiento());
        return result;
    }

    private EstudianteDto mapToDto(Estudiante entity){
        EstudianteDto result = new EstudianteDto();
        result.setId(entity.getId());
        result.setNombre(entity.getNombre());
        result.setApellido(entity.getApellido());
        result.setGenero(entity.getGenero());
        result.setCiudadOrigen(entity.getCiudadOrigen());
        result.setFechaNacimiento(entity.getFechaNacimiento());
        return result;
    }


}
