package com.example.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Embeddable
@EqualsAndHashCode
public class InscripcionPK {

    @Column(name = "id_carrera", nullable = false)
    private Integer idCarrera;


    @Column(name = "id_estudiante", nullable = false)
    private Integer idEstudiante;

}
