package com.iitca.tecnodesarrollo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.iitca.tecnodesarrollo.dto.ErrorMsg;
import com.iitca.tecnodesarrollo.dto.Acuifero;
import com.iitca.tecnodesarrollo.repo.AcuiferoRepo;

@Service
public class AcuiferoService {

	@Autowired
	private AcuiferoRepo acuiferoRepo;
	
	public List<Acuifero> listAll(){
		return acuiferoRepo.findAll();
	}
	
	public Object getacuiferoByAcu_clave(Integer acu_clave) {
            return acuiferoRepo.findById(acu_clave);
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
	
	public Acuifero saveacuifero(Acuifero acuifero) {
		return acuiferoRepo.save(acuifero);
	}
	
	public Acuifero updateacuifero(Integer Acu_clave, Acuifero acuiferoToUpate) {
		Optional<Acuifero> acuiferoFound = acuiferoRepo.findById(Acu_clave);
		if(acuiferoFound.isPresent()) {
			Acuifero acuiferoFoundToUpdate = acuiferoFound.get();
			acuiferoFoundToUpdate.setAcu_clave(acuiferoToUpate.getAcu_clave(	));
			acuiferoFoundToUpdate.setAcu_nombre(acuiferoToUpate.getAcu_nombre());
			acuiferoFoundToUpdate.setAcu_descripcion(acuiferoToUpate.getAcu_descripcion());
			//acuiferoFoundToUpdate.setAcu_limites(acuiferoToUpate.getA_limites());
			acuiferoFoundToUpdate.setAcu_num_op(acuiferoToUpate.getAcu_num_op());
			return acuiferoRepo.save(acuiferoFoundToUpdate);
		}else {
			return null;
		}
	}
	
	public void deleteacuifero(Integer acu_clave) {
		 acuiferoRepo.deleteById(acu_clave);
	}
}