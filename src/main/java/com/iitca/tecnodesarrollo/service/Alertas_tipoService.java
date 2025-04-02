package com.iitca.tecnodesarrollo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.iitca.tecnodesarrollo.dto.ErrorMsg;
import com.iitca.tecnodesarrollo.dto.Alertas_tipo;
import com.iitca.tecnodesarrollo.repo.Alertas_tipoRepo;

@Service
public class Alertas_tipoService {

	@Autowired
	private Alertas_tipoRepo alertas_tipoRepo;
	
	public List<Alertas_tipo> listAll(){
		return alertas_tipoRepo.findAll();
	}
	
	public Object getoperadoresByid(int id_alert) {
            return alertas_tipoRepo.findById(id_alert);
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
	
	public Alertas_tipo savealertas_tipo(Alertas_tipo alertas_tipo) {
		return alertas_tipoRepo.save(alertas_tipo);
	}
	
	public Alertas_tipo updatealertas_tipo(int id_alert, Alertas_tipo alertas_tipoToUpate) {
		Optional<Alertas_tipo> alertas_tipoFound = alertas_tipoRepo.findById(id_alert);
		if(alertas_tipoFound.isPresent()) {
			Alertas_tipo alertas_tipoFoundToUpdate = alertas_tipoFound.get();
			alertas_tipoFoundToUpdate.setAlert_tipo(alertas_tipoToUpate.getAlert_tipo(	));

			return alertas_tipoRepo.save(alertas_tipoFoundToUpdate);
		}else {
			return null;
		}
	}
	
	public void deletealertas_tipo(int id_alert) {
        alertas_tipoRepo.deleteById(id_alert);
	}
}