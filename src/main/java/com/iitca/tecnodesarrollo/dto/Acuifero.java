package com.iitca.tecnodesarrollo.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

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

    public int getId_acu() {
        return id_acu;
    }

    public void setId_acu(int id_acu) {
        this.id_acu = id_acu;
    }

    public Integer getAcu_clave() {
        return acu_clave;
    }

    public void setAcu_clave(Integer acu_clave) {
        this.acu_clave = acu_clave;
    }

    public String getAcu_nombre() {
        return acu_nombre;
    }

    public void setAcu_nombre(String acu_nombre) {
        this.acu_nombre = acu_nombre;
    }

    public String getAcu_descripcion() {
        return acu_descripcion;
    }

    public void setAcu_descripcion(String acu_descripcion) {
        this.acu_descripcion = acu_descripcion;
    }

    public byte[] getAcu_limites() {
        return Acu_limites;
    }

    public void setAcu_limites(byte[] Acu_limites) {
        this.Acu_limites = Acu_limites;
    }

    public Integer getAcu_num_op() {
        return acu_num_op;
    }

    public void setAcu_num_op(Integer acu_num_op) {
        this.acu_num_op = acu_num_op;
    }
	
	
	
}