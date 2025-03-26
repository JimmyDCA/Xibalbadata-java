package com.iitca.tecnodesarrollo.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "operacion")
public class Operacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id_op")
	private Integer id_op;
	@Column(name="op_cpozo")
	private String op_cpozo;
	@Column(name="op_fecha_captura", updatable = false, nullable = false)
	@CreationTimestamp
    private LocalDateTime op_fecha_captura; 
	//@Column(name="op_fcaptura")
	//private Timestamp op_fcaptura;
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
	
	
	
}