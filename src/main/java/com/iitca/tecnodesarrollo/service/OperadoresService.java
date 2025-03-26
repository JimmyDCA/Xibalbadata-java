package com.iitca.tecnodesarrollo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.iitca.tecnodesarrollo.dto.ErrorMsg;
import com.iitca.tecnodesarrollo.dto.Operadores;
import com.iitca.tecnodesarrollo.repo.OperadoresRepo;

@Service
public class OperadoresService {

	@Autowired
	private OperadoresRepo operadoresRepo;
	
	public List<Operadores> listAll(){
		return operadoresRepo.findAll();
	}
	
	public Object getoperadoresByid(int id_o) {
            return operadoresRepo.findById(id_o);
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
	
	public Operadores saveoperadores(Operadores operadores) {
		return operadoresRepo.save(operadores);
	}
	
	public Operadores updateoperadores(int id_o, Operadores operadoresToUpate) {
		Optional<Operadores> operadoresFound = operadoresRepo.findById(id_o);
		if(operadoresFound.isPresent()) {
			Operadores operadoresFoundToUpdate = operadoresFound.get();
			operadoresFoundToUpdate.setO_nombre(operadoresToUpate.getO_nombre(	));
            operadoresFoundToUpdate.setO_correo(operadoresToUpate.getO_correo(	));
            operadoresFoundToUpdate.setO_contrasena(operadoresToUpate.getO_contrasena(	));
            operadoresFoundToUpdate.setO_telefono(operadoresToUpate.getO_telefono(	));
			return operadoresRepo.save(operadoresFoundToUpdate);
		}else {
			return null;
		}
	}
	
	public void deleteoperadores(int id_o) {
		 operadoresRepo.deleteById(id_o);
	}
}