package com.iitca.tecnodesarrollo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "oo")
public class Oo {

	@Id
	@Column (name="Id_oo")
	private int id_oo;
	@Column(name="oo_acu_clave")
	private Integer oo_acu_clave;
	@Column(name="oo_nombre")
	private String oo_nombre;
	@Column(name = "oo_descripcion")
	private String oo_descripcion;
	//@Column(name="oo_docmentos")
	//private Blob oo_documentos;

    public int getId_oo() {
        return id_oo;
    }

    public void setId_oo(int id_oo) {
        this.id_oo = id_oo;
    }

    public Integer getOo_acu_clave() {
        return oo_acu_clave;
    }

    public void setOo_acu_clave(Integer oo_acu_clave) {
        this.oo_acu_clave = oo_acu_clave;
    }

    public String getOo_nombre() {
        return oo_nombre;
    }

    public void setOo_nombre(String oo_nombre) {
        this.oo_nombre = oo_nombre;
    }

    public String getOo_descripcion() {
        return oo_descripcion;
    }

    public void setOo_descripcion(String oo_descripcion) {
        this.oo_descripcion = oo_descripcion;
    }
	
	
	
}
