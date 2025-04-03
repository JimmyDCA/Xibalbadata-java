package com.iitca.tecnodesarrollo.dto;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

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
	@Column(name="Id_al")
	private int id_al;
	@Column(name="Al_clave_de_pozo")
	private String al_clave_de_pozo;
	@Column(name = "Al_tipo_de_alerta")
	private String al_tipo_de_alerta;
	@Column(name="Al_comentarios", columnDefinition="TEXT")
	private String al_comentarios;
	@Column(name = "Al_operador")
	private String al_operador;
	@CreationTimestamp
	@Column(name="Al_fechacap")
	private LocalDateTime al_fechacap;

}