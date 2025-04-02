package com.iitca.tecnodesarrollo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "acuifero")
public class Acuifero {

	@Id
	@Column(name= "Id_acu")
	private int id_acu;
	@Column(name="Acu_clave")
	private Integer acu_clave;
	@Column(name="acu_nombre")
	private String acu_nombre;
	@Column(name = "Acu_descripcion")
	private String acu_descripcion;
	@Lob
	@Column(name= "Acu_limites")
	private byte[] Acu_limites;
	@Column(name="acu_num_op")
	private Integer acu_num_op;
	
	
	
}