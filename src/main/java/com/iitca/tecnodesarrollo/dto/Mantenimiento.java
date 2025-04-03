package com.iitca.tecnodesarrollo.dto;

import java.time.LocalDateTime;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "mantenimiento")
public class Mantenimiento {

	@Id
	@Column(name="Id_mtto")
	private int id_mtto;
	@Column(name="mtto_operador")
	private int mtto_operador;
	@Column(name="mtto_clave_pozo")
	private String mtto_clave_pozo;
	@Column(name="mtto_fecha_captura")
    private LocalDateTime mtto_fecha_captura; 
	@Column(name = "mtto_motor_tipo")
	private String mtto_motor_tipo;
	@Column(name="mtto_motor_hp")
	private int mtto_motor_hp;
    @Column(name="mtto_motor_kw")
	private int mtto_motor_kw;
    @Column(name="mtto_motor_eficiencia")
	private int mtto_motor_eficiencia;
    @Column(name="mtto_tablero_tipo")
	private String mtto_tablero_tipo;
    @Column(name="mtto_tablero_capacidad")
	private int mtto_tablero_capacidad;
    @Column(name="mtto_transformador_tipo")
	private String mtto_transformador_tipo;
    @Column(name="mtto_transformador_capacidad")
	private int mtto_transformador_capacidad;
    @Column(name="mtto_cable_calibre")
	private String mtto_cable_calibre;
    @Column(name="mtto_cable_longitud")
	private int mtto_cable_longitud;
    @Column(name="mtto_tuberia_diametro")
	private int mtto_tuberia_diametro;
    @Column(name="mtto_tuberia_longitud")
	private int mtto_tuberia_longitud;
    @Column(name="mtto_observaciones")
	private String mtto_observaciones;
	
	
	
}