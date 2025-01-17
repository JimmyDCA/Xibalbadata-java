package com.iitca.tecnodesarrollo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "alertas_pozos")
public class Alertas_pozos {

	@Id
	@Column(name="Al_Clave_de_pozo")
	private String al_Clave_de_pozo;
	//@Column(name="Al_Fecha_de_captura")
	//private String al_Fecha_de_captura;

	@Column(name = "Al_Tipo_de_alerta")
	private String al_Tipo_de_alerta;
	@Column(name="Al_comentarios", columnDefinition="TEXT")
	private String al_comentarios;

}