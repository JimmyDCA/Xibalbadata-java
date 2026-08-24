package com.iitca.tecnodesarrollo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "alertas_tipo")
public class Alertas_tipo {

	@Id
	@Column(name="Id_alert")
	private int id_alert;
	@Column(name="alert_tipo")
	private String alert_tipo;

    public int getId_alert() {
        return id_alert;
    }

    public void setId_alert(int id_alert) {
        this.id_alert = id_alert;
    }

    public String getAlert_tipo() {
        return alert_tipo;
    }

    public void setAlert_tipo(String alert_tipo) {
        this.alert_tipo = alert_tipo;
    }
}