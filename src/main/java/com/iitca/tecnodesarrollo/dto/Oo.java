package com.iitca.tecnodesarrollo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "oo")
public class Oo {

	@Id
	@Column(name="oo_acu_clave")
	private Integer oo_acu_clave;
	@Column(name="oo_nombre")
	private String oo_nombre;
	@Column(name = "oo_descripcion")
	private String oo_descripcion;
	//@Column(name="oo_docmentos")
	//private Blob oo_documentos;
	
	
	
}
