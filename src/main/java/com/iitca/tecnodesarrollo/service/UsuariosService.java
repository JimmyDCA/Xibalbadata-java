package com.iitca.tecnodesarrollo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.iitca.tecnodesarrollo.dto.ErrorMsg;
import com.iitca.tecnodesarrollo.dto.Usuarios;
import com.iitca.tecnodesarrollo.repo.UsuariosRepo;

@Service
public class UsuariosService {

	@Autowired
	private UsuariosRepo usuariosRepo;
	
	public List<Usuarios> listAll(){
		return usuariosRepo.findAll();
	}
	
	public Object getusuariosByus_nombre(String us_nombre) {
            return usuariosRepo.findById(us_nombre);
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
	
	public Usuarios saveusuarios(Usuarios usuarios) {
		return usuariosRepo.save(usuarios);
	}
	
	public Usuarios updateusuarios(String us_nombre, Usuarios usuariosToUpate) {
		Optional<Usuarios> usuariosFound = usuariosRepo.findById(us_nombre);
		if(usuariosFound.isPresent()) {
			Usuarios usuariosFoundToUpdate = usuariosFound.get();
			usuariosFoundToUpdate.setUs_nombre(usuariosToUpate.getUs_nombre(	));
			usuariosFoundToUpdate.setUs_correo(usuariosToUpate.getUs_correo(	));
            usuariosFoundToUpdate.setUs_contrasena(usuariosToUpate.getUs_contrasena(	));
            usuariosFoundToUpdate.setUs_telefono(usuariosToUpate.getUs_telefono(	));
            usuariosFoundToUpdate.setUs_tipo(usuariosToUpate.getUs_tipo(	));
			return usuariosRepo.save(usuariosFoundToUpdate);
		}else {
			return null;
		}
	}
	
	public void deleteusuarios(String us_nombre) {
		 usuariosRepo.deleteById(us_nombre);
	}
}