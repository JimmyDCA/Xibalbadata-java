package com.iitca.tecnodesarrollo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.iitca.tecnodesarrollo.dto.ErrorMsg;
import com.iitca.tecnodesarrollo.dto.Lista_pozos;
import com.iitca.tecnodesarrollo.repo.Lista_pozosRepo;

@Service
public class Lista_pozosService {

	@Autowired
	private Lista_pozosRepo lista_pozosRepo;
	
	public List<Lista_pozos> listAll(){
		return lista_pozosRepo.findAll();
	}
	
	public Object getlista_pozosByL_poz_Clave(String l_poz_Clave) {
            return lista_pozosRepo.findById(l_poz_Clave);
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
	
	public Lista_pozos savelista_pozos(Lista_pozos lista_pozos) {
		return lista_pozosRepo.save(lista_pozos);
	}
	
	public Lista_pozos updatelista_pozos(String l_poz_Clave, Lista_pozos lista_pozosToUpate) {
		Optional<Lista_pozos> lista_pozosFound = lista_pozosRepo.findById(l_poz_Clave);
		if(lista_pozosFound.isPresent()) {
			Lista_pozos lista_pozosFoundToUpdate = lista_pozosFound.get();
			lista_pozosFoundToUpdate.setL_poz_clave(lista_pozosToUpate.getL_poz_clave(	));
			lista_pozosFoundToUpdate.setLp_Nombre(lista_pozosToUpate.getLp_Nombre());
			//lista_pozosFoundToUpdate.setLp_Ubicación(lista_pozosToUpate.getLp_Ubicación());
			lista_pozosFoundToUpdate.setLp_Profundidad_perforación(lista_pozosToUpate.getLp_Profundidad_perforación());
			lista_pozosFoundToUpdate.setLp_Diámetro_perforación(lista_pozosToUpate.getLp_Diámetro_perforación());
			lista_pozosFoundToUpdate.setLp_Diámetro_ADEME(lista_pozosToUpate.getLp_Diámetro_ADEME());
            //lista_pozosFoundToUpdate.setLp_Documentos(lista_pozosToUpate.getLp_Documentos());
			return lista_pozosRepo.save(lista_pozosFoundToUpdate);
		}else {
			return null;
		}
	}
	
	public void deletelista_pozos(String l_poz_clave) {
		 lista_pozosRepo.deleteById(l_poz_clave);
	}
}