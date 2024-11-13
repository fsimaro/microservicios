package com.example.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "estudiante")
@Entity
public class Estudiante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "fecha_nacimiento", nullable = false)
    private LocalDate fechaNacimiento;

    @Column(name = "genero", nullable = false)
    private String genero;

    @Column(name = "libreta_universitaria", unique = true)
    private String libretaUniversitaria;

    @Column(name = "numero_documento", nullable = false)
    private String numeroDocumento;

    @Column(name = "ciudad_origen", nullable = false)
    private String ciudadOrigen;

}
