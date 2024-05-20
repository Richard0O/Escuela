package com.escuela.Servicios;

import com.escuela.Modelo.*;
import com.escuela.Repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InscripcionService {
    @Autowired
    private InscripcionRepository inscripcionRepository;

    public Inscripcion saveInscripcion(Inscripcion inscripcion) {
        return inscripcionRepository.save(inscripcion);
    }

    public void deleteInscripcion(Long id) {
        inscripcionRepository.deleteById(id);
    }

    public Inscripcion updateInscripcion(Inscripcion inscripcion) {
        return inscripcionRepository.save(inscripcion);
    }

    public List<Inscripcion> getAllInscripciones() {
        return inscripcionRepository.findAll();
    }
    
    public void actualizarCalificacion(Long inscripcionId, float calificacion) {
        Inscripcion inscripcion = inscripcionRepository.findById(inscripcionId)
                .orElseThrow(() -> new RuntimeException("Inscripcion no encontrada con ID: " + inscripcionId));
        inscripcion.setCalificacion(calificacion);
        inscripcionRepository.save(inscripcion);
    }

    public void actualizarAsistencia(Long inscripcionId, int asistencia) {
        Inscripcion inscripcion = inscripcionRepository.findById(inscripcionId)
                .orElseThrow(() -> new RuntimeException("Inscripcion no encontrada con ID: " + inscripcionId));
        inscripcion.setAsistencia(asistencia);
        inscripcionRepository.save(inscripcion);
    }

}