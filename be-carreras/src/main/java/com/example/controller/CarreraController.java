package com.example.controller;

import com.example.dto.CarreraDto;
import com.example.dto.ReporteCarreraDto;
import com.example.service.CarreraService;
import com.example.service.InscripcionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.Caret;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/carreras")
public class CarreraController {

    private final CarreraService carreraService;
    private final InscripcionService inscripcionService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{idCarrera}/matricular-estudiante")
    public boolean matricularEstudiante(@PathVariable("idCarrera")Integer idCarrera,
                                     @RequestParam("idEstudiante")Integer idEstudiante)
    {
        return inscripcionService.matricularEstudiante(idEstudiante, idCarrera);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/por-inscriptos")
    public List<CarreraDto> getReportePorInscriptos(){
        return carreraService.getCarrerasOrdenadasPorInscriptos();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/reporte-completo")
    public List<ReporteCarreraDto> getReporteCompleto(){
        return carreraService.getReporteCarreras();
    }

}
