package com.iitca.tecnodesarrollo.dto;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "alertas_pozos")
public class Alertas_pozos {

	@Id
	@Column(name="Id_al")
	private int id_al;
	@Column(name = "Id_lp")
	private int idLp;
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

    public int getId_al() {
        return id_al;
    }

    public void setId_al(int id_al) {
        this.id_al = id_al;
    }

    public int getIdLp() {
        return idLp;
    }

    public void setIdLp(int idLp) {
        this.idLp = idLp;
    }

    public String getAl_clave_de_pozo() {
        return al_clave_de_pozo;
    }

    public void setAl_clave_de_pozo(String al_clave_de_pozo) {
        this.al_clave_de_pozo = al_clave_de_pozo;
    }

    public String getAl_tipo_de_alerta() {
        return al_tipo_de_alerta;
    }

    public void setAl_tipo_de_alerta(String al_tipo_de_alerta) {
        this.al_tipo_de_alerta = al_tipo_de_alerta;
    }

    public String getAl_comentarios() {
        return al_comentarios;
    }

    public void setAl_comentarios(String al_comentarios) {
        this.al_comentarios = al_comentarios;
    }

    public String getAl_operador() {
        return al_operador;
    }

    public void setAl_operador(String al_operador) {
        this.al_operador = al_operador;
    }

    public LocalDateTime getAl_fechacap() {
        return al_fechacap;
    }

    public void setAl_fechacap(LocalDateTime al_fechacap) {
        this.al_fechacap = al_fechacap;
    }

}