package com.iitca.tecnodesarrollo.dto;

//import java.sql.Blob;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "lista_pozos")
public class Lista_pozos {

	@Id
	@Column(name="Id_lp")
	private int id_lp;
	@Column(name="l_poz_Clave")
	private String l_poz_clave;
	@Column(name="lp_Nombre")
	private String lp_Nombre;
	@Column(name="lp_ramal")
	private String lp_ramal;
	//@Column(name="lp_Ubicación")
	//private Blob lp_Ubicación;
	@Column(name="lp_Profundidad_perforación")
	private Integer lp_Profundidad_perforación;
    @Column(name="lp_Diámetro_perforación")
	private Integer lp_Diámetro_perforación;
	@Column(name="lp_Diámetro_ADEME")
	private Integer lp_Diámetro_ADEME;
    //@Column(name="lp_Documentos")
	//private Blob lp_Documentos;

    public int getId_lp() {
        return id_lp;
    }

    public void setId_lp(int id_lp) {
        this.id_lp = id_lp;
    }

    public String getL_poz_clave() {
        return l_poz_clave;
    }

    public void setL_poz_clave(String l_poz_clave) {
        this.l_poz_clave = l_poz_clave;
    }

    public String getLp_Nombre() {
        return lp_Nombre;
    }

    public void setLp_Nombre(String lp_Nombre) {
        this.lp_Nombre = lp_Nombre;
    }

    public String getLp_ramal() {
        return lp_ramal;
    }

    public void setLp_ramal(String lp_ramal) {
        this.lp_ramal = lp_ramal;
    }

    public Integer getLp_Profundidad_perforación() {
        return lp_Profundidad_perforación;
    }

    public void setLp_Profundidad_perforación(Integer lp_Profundidad_perforación) {
        this.lp_Profundidad_perforación = lp_Profundidad_perforación;
    }

    public Integer getLp_Diámetro_perforación() {
        return lp_Diámetro_perforación;
    }

    public void setLp_Diámetro_perforación(Integer lp_Diámetro_perforación) {
        this.lp_Diámetro_perforación = lp_Diámetro_perforación;
    }

    public Integer getLp_Diámetro_ADEME() {
        return lp_Diámetro_ADEME;
    }

    public void setLp_Diámetro_ADEME(Integer lp_Diámetro_ADEME) {
        this.lp_Diámetro_ADEME = lp_Diámetro_ADEME;
    }

    }
	