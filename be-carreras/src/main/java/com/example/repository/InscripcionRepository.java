package com.example.repository;

import com.example.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Integer> {


    @Transactional
    @Query(value = "SELECT EXISTS " +
            "(SELECT 1 FROM Inscripcion i " +
            "WHERE i.idCarrera = :idCarrera + " +
            "AND i.idEstudiante = :idEstudiante)", nativeQuery = true)
    boolean existsById(@Param("idEstudiante")Integer idEstudiante, @Param("idCarrera")Integer idCarrera);

}
