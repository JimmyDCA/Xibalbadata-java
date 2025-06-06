package com.iitca.tecnodesarrollo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.iitca.tecnodesarrollo.dto.ErrorMsg;
import com.iitca.tecnodesarrollo.dto.Alertas_pozos;
import com.iitca.tecnodesarrollo.repo.Alertas_pozosRepo;

@Service
public class Alertas_pozosService {

	@Autowired
	private Alertas_pozosRepo alertas_pozosRepo;
	
	public List<Alertas_pozos> listAll(){
		return alertas_pozosRepo.findAll();
	}
	
	public Object getalertas_pozosByid(int id_al) {
            return alertas_pozosRepo.findById(id_al);
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

		public Object getalertas_pozosByIdPozo(int id_lp) {
            return alertas_pozosRepo.findByIdLp(id_lp);
	}
	
	public Alertas_pozos savealertas_pozos(Alertas_pozos alertas_pozos) {
		return alertas_pozosRepo.save(alertas_pozos);
	}
	
	public Alertas_pozos updatealertas_pozos(int id_al, Alertas_pozos alertas_pozosToUpate) {
		Optional<Alertas_pozos> alertas_pozosFound = alertas_pozosRepo.findById(id_al);
		if(alertas_pozosFound.isPresent()) {
			Alertas_pozos alertas_pozosFoundToUpdate = alertas_pozosFound.get();
            alertas_pozosFoundToUpdate.setAl_clave_de_pozo(alertas_pozosToUpate.getAl_clave_de_pozo(	));
			alertas_pozosFoundToUpdate.setAl_tipo_de_alerta(alertas_pozosToUpate.getAl_tipo_de_alerta());
			alertas_pozosFoundToUpdate.setAl_comentarios(alertas_pozosToUpate.getAl_comentarios());
			alertas_pozosFoundToUpdate.setAl_fechacap(alertas_pozosToUpate.getAl_fechacap());
			alertas_pozosFoundToUpdate.setAl_operador(alertas_pozosToUpate.getAl_operador());
			//alertas_pozosFoundToUpdate.setal_fechacap(alertas_pozosToUpate.getal_fechacap());
			return alertas_pozosRepo.save(alertas_pozosFoundToUpdate);
		}else {
			return null;
		}
	}
	
	public void deletealertas_pozos(int id_al) {
		 alertas_pozosRepo.deleteById(id_al);
	}
}