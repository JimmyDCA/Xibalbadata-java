package com.iitca.tecnodesarrollo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "alertas_tipo")
public class Alertas_tipo {

	@Id
	@Column(name="Id_alert")
	private int id_alert;
	@Column(name="alert_tipo")
	private String alert_tipo;
}