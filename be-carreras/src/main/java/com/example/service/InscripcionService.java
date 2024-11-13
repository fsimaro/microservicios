package com.example.service;

import com.example.model.Inscripcion;
import com.example.model.InscripcionPK;
import com.example.repository.InscripcionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@AllArgsConstructor
@Service
public class InscripcionService {

    private final InscripcionRepository inscripcionRepository;


    public boolean matricularEstudiante(Integer idEstudiante, Integer idCarrera){
        InscripcionPK pk = new InscripcionPK(idEstudiante, idCarrera);
        Inscripcion entidad = new Inscripcion(pk, LocalDate.now().getYear(), false);
        inscripcionRepository.save(entidad);
        return true;
    }

}
