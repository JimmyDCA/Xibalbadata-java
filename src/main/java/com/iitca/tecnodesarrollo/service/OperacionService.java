package com.iitca.tecnodesarrollo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.iitca.tecnodesarrollo.dto.ErrorMsg;
import com.iitca.tecnodesarrollo.dto.Operacion;
import com.iitca.tecnodesarrollo.repo.OperacionRepo;

@Service
public class OperacionService {

	@Autowired
	private OperacionRepo operacionRepo;
	
	public List<Operacion> listAll(){
		return operacionRepo.findAll();
	}
	
	public Object getoperacionByid(int id_op) {
            return operacionRepo.findById(id_op);

	}
	
	public Operacion saveoperacion(Operacion operacion) {
		return operacionRepo.save(operacion);
	}
	
	public Operacion updateoperacion(int id_op, Operacion operacionToUpate) {
		Optional<Operacion> operacionFound = operacionRepo.findById(id_op);
		if(operacionFound.isPresent()) {
			Operacion operacionFoundToUpdate = operacionFound.get();
			operacionFoundToUpdate.setOp_cpozo(operacionToUpate.getOp_cpozo(	));
            operacionFoundToUpdate.setOp_fecha_captura(operacionToUpate.getOp_fecha_captura(	));
			operacionFoundToUpdate.setOp_operador(operacionToUpate.getOp_operador(	));
            operacionFoundToUpdate.setOp_nestatico(operacionToUpate.getOp_nestatico(	));
            operacionFoundToUpdate.setOp_ndinamico(operacionToUpate.getOp_ndinamico(	));
            operacionFoundToUpdate.setOp_gasto(operacionToUpate.getOp_gasto(	));
            operacionFoundToUpdate.setOp_presion(operacionToUpate.getOp_presion(	));
            operacionFoundToUpdate.setOp_tiempo_op(operacionToUpate.getOp_tiempo_op(	));
            operacionFoundToUpdate.setOp_observaciones(operacionToUpate.getOp_observaciones(	));
			return operacionRepo.save(operacionFoundToUpdate);
		}else {
			return null;
		}
	}
	
	public void deleteoperacion(int id_op) {
        operacionRepo.deleteById(id_op);
	}
}