package com.example.service;

import com.example.dto.CarreraDto;
import com.example.dto.ReporteCarreraDto;
import com.example.repository.CarreraRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CarreraService {

    private final CarreraRepository carreraRepository;
    public List<CarreraDto> getCarrerasOrdenadasPorInscriptos(){
        System.out.println("Obteniendo resumen de carreras ordenadas por cantidad de inscriptos: ");
        List<CarreraDto> carreras = carreraRepository.getCarrerasOrdenadasPorInscriptos();
        for (CarreraDto carrera: carreras) System.out.println(carrera);
        return carreras;
    };
    public List<ReporteCarreraDto> getReporteCarreras() {
        System.out.println("Obteniendo reporte detallado de carreras:");
        List<ReporteCarreraDto> result = carreraRepository.getReporteCarreras();
        for (ReporteCarreraDto dto : result) {
            System.out.println(dto.getNombre());
            for (ReporteCarreraDto.DetalleCarreraAnual detalleAnual : dto.getDetalleAnual()) {
                System.out.println(detalleAnual.toString());
            }
        }
        return result;
    };

}
