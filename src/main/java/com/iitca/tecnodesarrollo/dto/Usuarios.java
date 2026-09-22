package com.iitca.tecnodesarrollo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonAlias;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_us")
    private int id_us;

    @Column(name = "us_matricula")
    private String us_matricula;

    @Column(name = "us_nombre")
    private String us_nombre;

    @Column(name = "us_correo")
    private String us_correo;

    // WRITE_ONLY: Permite recibirla en el POST, pero jamás la expone en respuestas JSON
    @JsonProperty(value= "us_contrasena", access = JsonProperty.Access.WRITE_ONLY)
    @JsonAlias ({"contrasena","us_contrasena"})
    @Column(name = "us_contrasena")
    private String us_contrasena;

    @Column(name = "us_telefono")
    private Long us_telefono;

    @Column(name = "us_tipo")
    private String us_tipo;

    public Usuarios() {}

    public int getId_us() {
        return id_us;
    }

    public void setId_us(int id_us) {
        this.id_us = id_us;
    }

    public String getUs_matricula() {
        return us_matricula;
    }

    public void setUs_matricula(String us_matricula) {
        this.us_matricula = us_matricula;
    }
    
    public String getUs_nombre() {
        return us_nombre;
    }

    public void setUs_nombre(String us_nombre) {
        this.us_nombre = us_nombre;
    }

    public String getUs_correo() {
        return us_correo;
    }

    public void setUs_correo(String us_correo) {
        this.us_correo = us_correo;
    }

    public String getUs_contrasena() {
        return us_contrasena;
    }

    public void setUs_contrasena(String us_contrasena) {
        this.us_contrasena = us_contrasena;
    }

    public Long getUs_telefono() {
        return us_telefono;
    }

    public void setUs_telefono(Long us_telefono) {
        this.us_telefono = us_telefono;
    }

    public String getUs_tipo() {
        return us_tipo;
    }

    public void setUs_tipo(String us_tipo) {
        this.us_tipo = us_tipo;
    }
}