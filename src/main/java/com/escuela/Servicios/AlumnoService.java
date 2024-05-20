package com.escuela.Servicios;


import com.escuela.Modelo.*;
import com.escuela.Repositorio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AlumnoService {
    @Autowired
    private AlumnoRepository alumnoRepository;

    public Alumno saveAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public void deleteAlumno(Long id) {
        alumnoRepository.deleteById(id);
    }

    public Alumno updateAlumno(Alumno alumno) {
        return alumnoRepository.save(alumno);
    }

    public List<Alumno> getAllAlumnos() {
        return alumnoRepository.findAll();
    }
}