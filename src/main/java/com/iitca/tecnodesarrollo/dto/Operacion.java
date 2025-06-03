package com.iitca.tecnodesarrollo.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "operacion")
public class Operacion {

	@Id
	@Column(name="Id_op")
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
	
	
	
}