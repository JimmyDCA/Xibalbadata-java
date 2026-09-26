package com.iitca.tecnodesarrollo.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "operacion")
public class Operacion {

	@Id
	@Column(name="op_id")
	private int id_op;

	@Column(name = "Id_lp")
	private int idLp;

	@Column(name="op_cpozo")
	private String op_cpozo;

	@CreationTimestamp
	@Column(name="op_fecha_captura")
    private LocalDateTime op_fecha_captura; 

	@Column(name = "op_operador")
	private String op_operador;

	//una vez enlazado con la app cambiar a int
	@Column(name = "op_nestatico")
	private float op_nestatico;

	@Column(name="op_ndinamico")
	private float op_ndinamico;

    @Column(name="op_gasto")
	private float op_gasto;

    @Column(name="op_presion")
	private float op_presion;

    @Column(name="op_tiempo_op")
	private float op_tiempo_op;

    @Column(name="op_observaciones")
	private String op_observaciones;

    @Column (name="op_operando")
    private String op_operando;  


    public int getId_op() {
        return id_op;
    }

    public void setId_op(int id_op) {
        this.id_op = id_op;
    }

    public int getIdLp() {
        return idLp;
    }

    public void setIdLp(int idLp) {
        this.idLp = idLp;
    }

    public String getOp_cpozo() {
        return op_cpozo;
    }

    public void setOp_cpozo(String op_cpozo) {
        this.op_cpozo = op_cpozo;
    }

    public LocalDateTime getOp_fecha_captura() {
        return op_fecha_captura;
    }

    public void setOp_fecha_captura(LocalDateTime op_fecha_captura) {
        this.op_fecha_captura = op_fecha_captura;
    }

    public String getOp_operador() {
        return op_operador;
    }

    public void setOp_operador(String op_operador) {
        this.op_operador = op_operador;
    }

    public float getOp_nestatico() {
        return op_nestatico;
    }

    public void setOp_nestatico(float op_nestatico) {
        this.op_nestatico = op_nestatico;
    }

    public float getOp_ndinamico() {
        return op_ndinamico;
    }

    public void setOp_ndinamico(float op_ndinamico) {
        this.op_ndinamico = op_ndinamico;
    }

    public float getOp_gasto() {
        return op_gasto;
    }

    public void setOp_gasto(float op_gasto) {
        this.op_gasto = op_gasto;
    }

    public float getOp_presion() {
        return op_presion;
    }

    public void setOp_presion(float op_presion) {
        this.op_presion = op_presion;
    }

    public float getOp_tiempo_op() {
        return op_tiempo_op;
    }

    public void setOp_tiempo_op(float op_tiempo_op) {
        this.op_tiempo_op = op_tiempo_op;
    }

    public String getOp_observaciones() {
        return op_observaciones;
    }

    public void setOp_observaciones(String op_observaciones) {
        this.op_observaciones = op_observaciones;
    }

    public String getOp_operando() {
        return op_operando;
    }

    public void setOp_operando(String op_operando) {
        this.op_operando = op_operando;
    }
	
	
	
}