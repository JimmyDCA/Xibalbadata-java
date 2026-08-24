package com.iitca.tecnodesarrollo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuarios {

	@Id
	@Column(name="Id_us")
	private int id_us;
	@Column(name="us_nombre")
	private String us_nombre;
	@Column(name="us_correo")
	private String us_correo;
	@Column(name = "us_contrasena")
	private String us_contrasena;
	@Column(name="us_telefono")
	private Integer us_telefono;
    @Column(name = "us_tipo")
	private String us_tipo;

    public int getId_us() {
        return id_us;
    }

    public void setId_us(int id_us) {
        this.id_us = id_us;
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

    public Integer getUs_telefono() {
        return us_telefono;
    }

    public void setUs_telefono(Integer us_telefono) {
        this.us_telefono = us_telefono;
    }

    public String getUs_tipo() {
        return us_tipo;
    }

    public void setUs_tipo(String us_tipo) {
        this.us_tipo = us_tipo;
    }
	
	
	
}