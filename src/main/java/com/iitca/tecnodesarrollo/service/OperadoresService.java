package com.iitca.tecnodesarrollo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.iitca.tecnodesarrollo.dto.ErrorMsg;
import com.iitca.tecnodesarrollo.dto.Operadores;
import com.iitca.tecnodesarrollo.dto.Usuarios;
import com.iitca.tecnodesarrollo.repo.OperadoresRepo;
import com.iitca.tecnodesarrollo.repo.UsuariosRepo;

@Service
public class OperadoresService {

	@Autowired
	private OperadoresRepo operadoresRepo;
	
	@Autowired
	private UsuariosRepo usuariosRepo;


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
	
	
	public Operadores updateoperadores(int id_o, Operadores operadoresToUpate) {
		Optional<Operadores> operadoresFound = operadoresRepo.findById(id_o);
		if(operadoresFound.isPresent()) {
			Operadores operadoresFoundToUpdate = operadoresFound.get();
			operadoresFoundToUpdate.setO_nombre(operadoresToUpate.getO_nombre(	));
			operadoresFoundToUpdate.setO_matricula(operadoresToUpate.getO_matricula(	));
            operadoresFoundToUpdate.setO_correo(operadoresToUpate.getO_correo(	));
            operadoresFoundToUpdate.setO_contrasena(operadoresToUpate.getO_contrasena(	));
            operadoresFoundToUpdate.setO_telefono(operadoresToUpate.getO_telefono(	));
			return operadoresRepo.save(operadoresFoundToUpdate);
		}else {
			return null;
		}
	}
	
	public void deleteoperadores(int id_o) {
		// 1. Buscar al operador antes de borrarlo para obtener su correo
        Optional<Operadores> operadorFound = operadoresRepo.findById(id_o);
        
        if (operadorFound.isPresent()) {
            String correo = operadorFound.get().getO_correo();
            
            // 2. Si tiene correo, eliminarlo de la tabla usuarios
            if (correo != null && !correo.trim().isEmpty()) {
                usuariosRepo.deleteByUs_correo(correo);
            }
            
            // 3. Eliminar de la tabla operadores
            operadoresRepo.deleteById(id_o);
		}
	}

	public Operadores saveOperador(Operadores operador) {
		// 1. Guardar el operador
		Operadores nuevoOp = operadoresRepo.save(operador);

		// 2. Crear y guardar en la tabla usuarios
		Usuarios usuario = new Usuarios();
		usuario.setUs_nombre(operador.getO_nombre());
		usuario.setUs_matricula(operador.getO_matricula());
		usuario.setUs_correo(operador.getO_correo());
		usuario.setUs_contrasena(operador.getO_contrasena());
		usuario.setUs_telefono(operador.getO_telefono());
		usuario.setUs_tipo("operador");
		usuariosRepo.save(usuario);

		return nuevoOp;
	}
}