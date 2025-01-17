package com.iitca.tecnodesarrollo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "acuifero")
public class Acuifero {

	@Id
	@Column(name="Acu_clave")
	private Integer acu_clave;
	@Column(name="acu_nombre")
	private String acu_nombre;
	@Column(name = "Acu_descripcion", columnDefinition="TEXT")
	private String acu_descripcion;
	//private Blob Acu_limites;
	@Column(name="acu_num_op")
	private Integer acu_num_op;
	
	
	
}