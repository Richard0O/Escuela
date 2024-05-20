package com.escuela.Controladores;

import com.escuela.Modelo.*;
import com.escuela.Servicios.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    // Método para crear un nuevo curso. http://localhost:8080/api/curso/create
    @PostMapping("/create")
    public Curso createCurso(@RequestBody Curso curso) {
        return cursoService.saveCurso(curso);
    }

    // Método para eliminar un curso por su ID. http://localhost:8080/api/curso/delete/id
    @DeleteMapping("/delete/{id}")
    public void deleteCurso(@PathVariable Long id) {
        cursoService.deleteCurso(id);
    }

    // Método para actualizar los datos del curso.  http://localhost:8080/api/curso/update/id
    @PutMapping("/update/{id}")
    public Curso updateCurso(@PathVariable Long id, @RequestBody Curso curso) {
        curso.setId(id);
        return cursoService.updateCurso(curso);
    }

    // Método para obtener todos los alumnos. http://localhost:8080/api/cursos
    @GetMapping
    public List<Curso> getAllCursos() {
        return cursoService.getAllCursos();
    }
}