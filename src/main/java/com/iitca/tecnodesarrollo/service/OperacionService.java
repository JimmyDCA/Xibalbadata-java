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
	
	public Object getoperacionByOp_cpozo(String op_cpozo) {
            return operacionRepo.findById(op_cpozo);
		/*Optional<Pozo> pozoFound =  pozoRepo.findById(idPozo);
		if(pozoFound.isPresent()) {
			return pozoFound.get();
		}else {
			ErrorMsg error = new ErrorMsg();
			error.setErrorCode(400);
			error.setMessageCode("No existe el pozo "+idPozo);
			return	error;
		}*/
		 
	}
	
	public Operacion saveoperacion(Operacion operacion) {
		return operacionRepo.save(operacion);
	}
	
	public Operacion updateoperacion(String op_cpozo, Operacion operacionToUpate) {
		Optional<Operacion> operacionFound = operacionRepo.findById(op_cpozo);
		if(operacionFound.isPresent()) {
			Operacion operacionFoundToUpdate = operacionFound.get();
			operacionFoundToUpdate.setOp_cpozo(operacionToUpate.getOp_cpozo(	));
            //operacionFoundToUpdate.setOp_fcaptura(operacionToUpate.getOp_fcaptura(	));
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
	
	public void deleteoperacion(String op_cpozo) {
        operacionRepo.deleteById(op_cpozo);
	}
}