package com.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@Table(name = "estudiante_carrera")
@Entity
public class Inscripcion {

    @EmbeddedId
    private InscripcionPK pk;

    @Column(name = "anio_inscripcion", nullable = false)
    private Integer anioInscripcion;

    @Column(name = "graduado", nullable = false)
    private boolean graduado;
}
