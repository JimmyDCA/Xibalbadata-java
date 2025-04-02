package com.iitca.tecnodesarrollo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
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
	
	
	
}