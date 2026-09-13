package com.iitca.tecnodesarrollo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "operadores")
public class Operadores {

	@Id
	@Column(name="Id_o")
	private int id_o;
    @Column(name="o_matricula")
	private String o_matricula;
	@Column(name="o_nombre")
	private String o_nombre;
	@Column(name="o_correo")
	private String o_correo;
	@Column(name = "o_contrasena")
	private String o_contrasena;
	@Column(name="o_telefono")
	private long o_telefono;

    public int getId_o() {
        return id_o;
    }

    public void setId_o(int id_o) {
        this.id_o = id_o;
    }

    public String getO_matricula() {
        return o_matricula;
    }

    public void setO_matricula(String o_matricula) {
        this.o_matricula = o_matricula;
    }

    public String getO_nombre() {
        return o_nombre;
    }

    public void setO_nombre(String o_nombre) {
        this.o_nombre = o_nombre;
    }

    public String getO_correo() {
        return o_correo;
    }

    public void setO_correo(String o_correo) {
        this.o_correo = o_correo;
    }

    public String getO_contrasena() {
        return o_contrasena;
    }

    public void setO_contrasena(String o_contrasena) {
        this.o_contrasena = o_contrasena;
    }

    public long getO_telefono() {
        return o_telefono;
    }

    public void setO_telefono(long o_telefono) {
        this.o_telefono = o_telefono;
    }
	
	
	
}