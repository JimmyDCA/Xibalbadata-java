package com.iitca.tecnodesarrollo.service;

//import java.time.LocalDateTime;
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
		/*Operacion ope1 = new Operacion();
		ope1.setId_op(1);
		ope1.setOp_cpozo("P.A. 138");
		ope1.setOp_fecha_captura(LocalDateTime.of(2025, 2, 4, 0, 0, 0));
		ope1.setOp_gasto(12);
		ope1.setOp_nestatico(63);
		ope1.setOp_tiempo_op(23);

		Operacion ope2 = new Operacion();
		ope2.setId_op(2);
		ope2.setOp_cpozo("P.A. 138");
		ope2.setOp_fecha_captura(LocalDateTime.of(2025, 2, 6, 0, 0, 0));
		ope2.setOp_gasto(12);
		ope2.setOp_nestatico(64);
		ope2.setOp_tiempo_op(24);

		Operacion ope3 = new Operacion();
		ope3.setId_op(2);
		ope3.setOp_cpozo("P.A. 138");
		ope3.setOp_fecha_captura(LocalDateTime.of(2025, 2, 6, 0, 0, 0));
		ope3.setOp_gasto(12);
		ope3.setOp_nestatico(64);
		ope3.setOp_tiempo_op(24);*/


		return operacionRepo.findAll();
	}
	
	public Object getoperacionByid(int id_op) {
            return operacionRepo.findById(id_op);
	}
	
	public Object getoperacionByIdPozo(int id_lp) {
            return operacionRepo.findByIdLp(id_lp);
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