package com.iitca.tecnodesarrollo.dto;

import java.time.LocalDateTime;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mantenimiento")
public class Mantenimiento {

	@Id
	@Column(name="Id_lp")
	private int idLp;
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

    public int getIdLp() {
        return idLp;
    }

    public void setIdLp(int idLp) {
        this.idLp = idLp;
    }

    public int getMtto_operador() {
        return mtto_operador;
    }

    public void setMtto_operador(int mtto_operador) {
        this.mtto_operador = mtto_operador;
    }

    public String getMtto_clave_pozo() {
        return mtto_clave_pozo;
    }

    public void setMtto_clave_pozo(String mtto_clave_pozo) {
        this.mtto_clave_pozo = mtto_clave_pozo;
    }

    public LocalDateTime getMtto_fecha_captura() {
        return mtto_fecha_captura;
    }

    public void setMtto_fecha_captura(LocalDateTime mtto_fecha_captura) {
        this.mtto_fecha_captura = mtto_fecha_captura;
    }

    public String getMtto_motor_tipo() {
        return mtto_motor_tipo;
    }

    public void setMtto_motor_tipo(String mtto_motor_tipo) {
        this.mtto_motor_tipo = mtto_motor_tipo;
    }

    public int getMtto_motor_hp() {
        return mtto_motor_hp;
    }

    public void setMtto_motor_hp(int mtto_motor_hp) {
        this.mtto_motor_hp = mtto_motor_hp;
    }

    public int getMtto_motor_kw() {
        return mtto_motor_kw;
    }

    public void setMtto_motor_kw(int mtto_motor_kw) {
        this.mtto_motor_kw = mtto_motor_kw;
    }

    public int getMtto_motor_eficiencia() {
        return mtto_motor_eficiencia;
    }

    public void setMtto_motor_eficiencia(int mtto_motor_eficiencia) {
        this.mtto_motor_eficiencia = mtto_motor_eficiencia;
    }

    public String getMtto_tablero_tipo() {
        return mtto_tablero_tipo;
    }

    public void setMtto_tablero_tipo(String mtto_tablero_tipo) {
        this.mtto_tablero_tipo = mtto_tablero_tipo;
    }

    public int getMtto_tablero_capacidad() {
        return mtto_tablero_capacidad;
    }

    public void setMtto_tablero_capacidad(int mtto_tablero_capacidad) {
        this.mtto_tablero_capacidad = mtto_tablero_capacidad;
    }

    public String getMtto_transformador_tipo() {
        return mtto_transformador_tipo;
    }

    public void setMtto_transformador_tipo(String mtto_transformador_tipo) {
        this.mtto_transformador_tipo = mtto_transformador_tipo;
    }

    public int getMtto_transformador_capacidad() {
        return mtto_transformador_capacidad;
    }

    public void setMtto_transformador_capacidad(int mtto_transformador_capacidad) {
        this.mtto_transformador_capacidad = mtto_transformador_capacidad;
    }

    public String getMtto_cable_calibre() {
        return mtto_cable_calibre;
    }

    public void setMtto_cable_calibre(String mtto_cable_calibre) {
        this.mtto_cable_calibre = mtto_cable_calibre;
    }

    public int getMtto_cable_longitud() {
        return mtto_cable_longitud;
    }

    public void setMtto_cable_longitud(int mtto_cable_longitud) {
        this.mtto_cable_longitud = mtto_cable_longitud;
    }

    public int getMtto_tuberia_diametro() {
        return mtto_tuberia_diametro;
    }

    public void setMtto_tuberia_diametro(int mtto_tuberia_diametro) {
        this.mtto_tuberia_diametro = mtto_tuberia_diametro;
    }

    public int getMtto_tuberia_longitud() {
        return mtto_tuberia_longitud;
    }

    public void setMtto_tuberia_longitud(int mtto_tuberia_longitud) {
        this.mtto_tuberia_longitud = mtto_tuberia_longitud;
    }

    public String getMtto_observaciones() {
        return mtto_observaciones;
    }

    public void setMtto_observaciones(String mtto_observaciones) {
        this.mtto_observaciones = mtto_observaciones;
    }
	
	
	
}