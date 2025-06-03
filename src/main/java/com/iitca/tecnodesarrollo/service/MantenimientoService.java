package com.iitca.tecnodesarrollo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iitca.tecnodesarrollo.dto.Mantenimiento;
import com.iitca.tecnodesarrollo.repo.MantenimientoRepo;

@Service
public class MantenimientoService {

	@Autowired
	private MantenimientoRepo mantenimientoRepo;
	
	public List<Mantenimiento> listAll(){
		return mantenimientoRepo.findAll();
	}
	
	public Object getmantenimientoByid(int id_mtto) {
            return mantenimientoRepo.findById(id_mtto);
		 
	}

		public Object getmantenimientoByIdPozo(int id_lp) {
            return mantenimientoRepo.findByIdLp(id_lp);
		 
	}


	public Mantenimiento savemantenimiento(Mantenimiento mantenimiento) {
		return mantenimientoRepo.save(mantenimiento);
	}
	
	public Mantenimiento updatemantenimiento(int id_mtto, Mantenimiento mantenimientoToUpate) {
		Optional<Mantenimiento> mantenimientoFound = mantenimientoRepo.findById(id_mtto);
		if(mantenimientoFound.isPresent()) {
			Mantenimiento mantenimientoFoundToUpdate = mantenimientoFound.get();
			mantenimientoFoundToUpdate.setMtto_operador(mantenimientoToUpate.getMtto_operador(	));
			mantenimientoFoundToUpdate.setMtto_clave_pozo(mantenimientoToUpate.getMtto_clave_pozo(	));
			mantenimientoFoundToUpdate.setMtto_fecha_captura(mantenimientoToUpate.getMtto_fecha_captura());
			mantenimientoFoundToUpdate.setMtto_motor_tipo(mantenimientoToUpate.getMtto_motor_tipo());
			mantenimientoFoundToUpdate.setMtto_motor_hp(mantenimientoToUpate.getMtto_motor_hp());
			mantenimientoFoundToUpdate.setMtto_motor_kw(mantenimientoToUpate.getMtto_motor_kw());
			mantenimientoFoundToUpdate.setMtto_motor_eficiencia(mantenimientoToUpate.getMtto_motor_eficiencia());
			mantenimientoFoundToUpdate.setMtto_tablero_tipo(mantenimientoToUpate.getMtto_tablero_tipo());
			mantenimientoFoundToUpdate.setMtto_tablero_capacidad(mantenimientoToUpate.getMtto_tablero_capacidad());
			mantenimientoFoundToUpdate.setMtto_transformador_tipo(mantenimientoToUpate.getMtto_transformador_tipo());
			mantenimientoFoundToUpdate.setMtto_transformador_capacidad(mantenimientoToUpate.getMtto_transformador_capacidad());
			mantenimientoFoundToUpdate.setMtto_cable_calibre(mantenimientoToUpate.getMtto_cable_calibre());
			mantenimientoFoundToUpdate.setMtto_cable_longitud(mantenimientoToUpate.getMtto_cable_longitud());
			mantenimientoFoundToUpdate.setMtto_tuberia_diametro(mantenimientoToUpate.getMtto_tuberia_diametro());
			mantenimientoFoundToUpdate.setMtto_tuberia_longitud(mantenimientoToUpate.getMtto_tuberia_longitud());
			mantenimientoFoundToUpdate.setMtto_observaciones(mantenimientoToUpate.getMtto_observaciones());
			return mantenimientoRepo.save(mantenimientoFoundToUpdate);
		}else {
			return null;
		}
	}
	
	public void deletemantenimiento(int id_mtto) {
		 mantenimientoRepo.deleteById(id_mtto);
	}
}