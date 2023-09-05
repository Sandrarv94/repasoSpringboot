package com.example.mercancia.modelos;

import jakarta.persistence.*;

@Entity
@Table(name="mercancia")
public class Mercancia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer referencia;
    private String nombre;
    private Double precio;


    public Mercancia() {
    }

    public Mercancia(Integer id, Integer referencia, String nombre, Double precio) {
        this.id = id;
        this.referencia = referencia;
        this.nombre = nombre;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getReferencia() {
        return referencia;
    }

    public void setReferencia(Integer referencia) {
        this.referencia = referencia;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
