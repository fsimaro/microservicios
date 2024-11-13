package com.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Setter
@Getter
@Table(name = "carrera")
@Entity
public class Carrera {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @OneToMany(mappedBy = "carrera_id")
    private List<Inscripcion> inscripciones;


}
