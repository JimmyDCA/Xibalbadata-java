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
	@Column(name="L_poz_Clave")
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

    }
	