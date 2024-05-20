package com.escuela.Modelo;

import jakarta.persistence.*;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @Enumerated(EnumType.STRING)
    private TipoAprobacion tipoAprobacion;

    // getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoAprobacion getTipoAprobacion() {
        return tipoAprobacion;
    }

    public void setTipoAprobacion(TipoAprobacion tipoAprobacion) {
        this.tipoAprobacion = tipoAprobacion;
    }
}
