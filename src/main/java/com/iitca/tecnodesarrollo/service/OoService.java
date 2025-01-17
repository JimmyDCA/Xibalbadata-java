package com.iitca.tecnodesarrollo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.iitca.tecnodesarrollo.dto.ErrorMsg;
import com.iitca.tecnodesarrollo.dto.Oo;
import com.iitca.tecnodesarrollo.repo.OoRepo;

@Service
public class OoService {

	@Autowired
	private OoRepo ooRepo;
	
	public List<Oo> listAll(){
		return ooRepo.findAll();
	}
	
	public Object getooByOo_nombre(String oo_nombre) {
            return ooRepo.findById(oo_nombre);
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
	
	public Oo saveoo(Oo oo) {
		return ooRepo.save(oo);
	}
	
	public Oo updateoo(String oo_nombre, Oo ooToUpate) {
		Optional<Oo> ooFound = ooRepo.findById(oo_nombre);
		if(ooFound.isPresent()) {
			Oo ooFoundToUpdate = ooFound.get();
			ooFoundToUpdate.setOo_acu_clave(ooToUpate.getOo_acu_clave(	));
            ooFoundToUpdate.setOo_nombre(ooToUpate.getOo_nombre(	));
            ooFoundToUpdate.setOo_descripcion(ooToUpate.getOo_descripcion(	));
            //ooFoundToUpdate.setOo_documentos(ooToUpate.getOo_documentos(	));
			return ooRepo.save(ooFoundToUpdate);
		}else {
			return null;
		}
	}
	
	public void deleteoo(String oo_nombre) {
		 ooRepo.deleteById(oo_nombre);
	}
}