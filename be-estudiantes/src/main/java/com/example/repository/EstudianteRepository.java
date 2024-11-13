package com.example.repository;

import com.example.model.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

    /**
     * @see EstudianteRepository
     */
    @Transactional(readOnly = true)
    @Query("SELECT e " +
            "FROM Estudiante e " +
            "WHERE e.libretaUniversitaria = :libretaUniversitaria")
    Optional<Estudiante> findByLibretaUniversitaria(@Param("libretaUniversitaria") String libretaUniversitaria);

    /**
     * @see EstudianteRepository
     */
    @Transactional(readOnly = true)
    @Query("SELECT e " +
            "FROM Estudiante e " +
            "WHERE e.genero = :genero")
    List<Estudiante> findAllByGenero(String genero);

}
