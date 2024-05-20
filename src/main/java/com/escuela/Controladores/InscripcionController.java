package com.escuela.Controladores;

import com.escuela.Modelo.*;
import com.escuela.Servicios.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionController {
    @Autowired
    private InscripcionService inscripcionService;

    // Método para crear una inscripción.
    // http://localhost:8080/api/inscripcion/create
    @PostMapping("/create")
    public Inscripcion createInscripcion(@RequestBody Inscripcion inscripcion) {
        return inscripcionService.saveInscripcion(inscripcion);
    }

    // Método para eliminar una inscripcion por su ID.
    // http://localhost:8080/api/inscripcion/delete/id
    @DeleteMapping("/delete/{id}")
    public void deleteInscripcion(@PathVariable Long id) {
        inscripcionService.deleteInscripcion(id);
    }

    // Método para actualizar los datos del curso.
    // http://localhost:8080/api/inscripcion/delete/id
    @PutMapping("/update/{id}")
    public Inscripcion updateInscripcion(@PathVariable Long id, @RequestBody Inscripcion inscripcion) {
        inscripcion.setId(id);
        return inscripcionService.updateInscripcion(inscripcion);
    }

    // Método para obtener todos las inscripciones. http://localhost:8080/api/inscripciones
    @GetMapping
    public List<Inscripcion> getAllInscripciones() {
        return inscripcionService.getAllInscripciones();
    }

    //http://localhost:8080/api/inscripciones/aprobacion/5
    @GetMapping("/aprobacion/{cursoId}")
    public List<String> getAprobacionPorCurso(@PathVariable Long cursoId) {
        List<Inscripcion> inscripciones = inscripcionService.getAllInscripciones();
        String nombreCurso = null;
        List<String> resultado = new ArrayList<>();

        for (Inscripcion inscripcion : inscripciones) {
            if (inscripcion.getCurso().getId().equals(cursoId)) {
                if (nombreCurso == null || !nombreCurso.equals(inscripcion.getCurso().getNombre())) {
                    nombreCurso = inscripcion.getCurso().getNombre();
                    resultado.add("Curso: " + nombreCurso);
                }

                String estado = "NO APROBADO";
                if (inscripcion.getCurso().getTipoAprobacion() == TipoAprobacion.asistencia &&
                        inscripcion.getAsistencia() >= 80) {
                    estado = "APROBADO";
                } else if (inscripcion.getCurso().getTipoAprobacion() == TipoAprobacion.calificacion &&
                        inscripcion.getCalificacion() >= 7) {
                    estado = "APROBADO";
                }
                resultado.add(inscripcion.getAlumno().getNombre() + " " + inscripcion.getAlumno().getApellido() +
                        ": " + estado);
            }
        }

        return resultado;
    }

    // Método para actualizar la calificación de una inscripción.
    // http://localhost:8080/api/inscripciones/id/calificacion/9.0
    @PutMapping("/{id}/calificacion/{calificacion}")
    public ResponseEntity<String> actualizarCalificacion(@PathVariable Long id, @PathVariable float calificacion) {
        inscripcionService.actualizarCalificacion(id, calificacion);
        return ResponseEntity.ok("Calificación actualizada exitosamente.");
    }

    // Método para actualizar la asistencia de una inscripción.
    // http://localhost:8080/api/inscripciones/id/asistencia/70
    @PutMapping("/{id}/asistencia/{asistencia}")
    public ResponseEntity<String> actualizarAsistencia(@PathVariable Long id, @PathVariable int asistencia) {
        inscripcionService.actualizarAsistencia(id, asistencia);
        return ResponseEntity.ok("Asistencia actualizada exitosamente.");
    }

}