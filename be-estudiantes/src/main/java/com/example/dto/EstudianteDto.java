package com.example.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EstudianteDto {

    private Integer id;
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String genero;
    private String libretaUniversitaria;
    private String numeroDocumento;
    private String ciudadOrigen;

}
