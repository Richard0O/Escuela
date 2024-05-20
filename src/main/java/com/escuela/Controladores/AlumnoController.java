package com.escuela.Controladores;

import com.escuela.Modelo.*;
import com.escuela.Servicios.AlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    @Autowired
    private AlumnoService alumnoService;

    // Método para crear un nuevo alumno. http://localhost:8080/api/alumnos/create
    @PostMapping("/create")
    public Alumno createAlumno(@RequestBody Alumno alumno) {
        return alumnoService.saveAlumno(alumno);
    }

    // Método para eliminar un alumno por su ID. http://localhost:8080/api/alumnos/delete/id
    @DeleteMapping("/delete/{id}")
    public void deleteAlumno(@PathVariable Long id) {
        alumnoService.deleteAlumno(id);
    }

    // Método para actualizar los datos de un alumno. http://localhost:8080/api/alumnos/update/id
    @PutMapping("/update/{id}")
    public Alumno updateAlumno(@PathVariable Long id, @RequestBody Alumno alumno) {
        alumno.setId(id);
        return alumnoService.updateAlumno(alumno);
    }

    // Método para obtener todos los alumnos. http://localhost:8080/api/alumnos
    @GetMapping
    public List<Alumno> getAllAlumnos() {
        return alumnoService.getAllAlumnos();
    }
}
