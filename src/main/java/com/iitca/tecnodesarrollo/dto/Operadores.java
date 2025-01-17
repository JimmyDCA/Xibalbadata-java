package com.iitca.tecnodesarrollo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "operadores")
public class Operadores {

	@Id
	@Column(name="o_nombre")
	private String o_nombre;
	@Column(name="o_correo")
	private String o_correo;
	@Column(name = "o_contrasena")
	private String o_contrasena;
	@Column(name="o_telefono")
	private String o_telefono;
	
	
	
}