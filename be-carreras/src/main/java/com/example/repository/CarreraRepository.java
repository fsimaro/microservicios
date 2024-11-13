package com.example.repository;

import com.example.dto.CarreraDto;
import com.example.dto.ReporteCarreraDto;
import com.example.model.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CarreraRepository extends JpaRepository<Carrera, Integer> {

    @Transactional(readOnly = true)
    @Query("SELECT NEW com.example.dto.CarreraDto(c.nombre, SUM(CASE WHEN ec.graduado = false THEN 1 ELSE 0 END) as inscriptos) " +
            "FROM Carrera c " +
            "JOIN EstudianteCarrera ec ON (ec.idCarrera = c.id) " +
            "GROUP BY c.nombre " +
            "ORDER BY inscriptos DESC")
    List<CarreraDto> getCarrerasOrdenadasPorInscriptos();

    /**
     * @see CarreraRepository
     */
    @Transactional(readOnly = true)
    @Query("SELECT NEW com.example.ReporteCarreraDto(c.nombre, ec.anioInscripcion, COUNT(ec.idEstudiante) as inscriptos, SUM(CASE WHEN ec.graduado = FALSE THEN 0 ELSE 1 END) as graduados) " +
            "FROM Carrera c " +
            "JOIN Inscripcion i ON (i.idCarrera = c.id) " +
            "GROUP BY c.nombre, ec.anioInscripcion " +
            "ORDER BY c.nombre ASC, ec.anioInscripcion ASC")
    List<ReporteCarreraDto> getReporteCarreras();

}
