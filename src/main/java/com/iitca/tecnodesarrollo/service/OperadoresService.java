package com.iitca.tecnodesarrollo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<Operadores> listAll(){
        return operadoresRepo.findAll();
    }
    
    public Object getoperadoresByid(int id_o) {
        return operadoresRepo.findById(id_o);
    }
    
    @Transactional
    public Operadores updateoperadores(int id_o, Operadores operadoresToUpate) {
        Optional<Operadores> operadoresFound = operadoresRepo.findById(id_o);
        if(operadoresFound.isPresent()) {
            Operadores operadoresFoundToUpdate = operadoresFound.get();
            operadoresFoundToUpdate.setO_nombre(operadoresToUpate.getO_nombre());
            operadoresFoundToUpdate.setO_matricula(operadoresToUpate.getO_matricula());
            operadoresFoundToUpdate.setO_correo(operadoresToUpate.getO_correo());
            
            // Cifra la contraseña si se está enviando una nueva en la actualización
            if (operadoresToUpate.getO_contrasena() != null && !operadoresToUpate.getO_contrasena().trim().isEmpty()) {
                operadoresFoundToUpdate.setO_contrasena(passwordEncoder.encode(operadoresToUpate.getO_contrasena()));
            }
            
            operadoresFoundToUpdate.setO_telefono(operadoresToUpate.getO_telefono());
            return operadoresRepo.save(operadoresFoundToUpdate);
        } else {
            return null;
        }
    }
    
    @Transactional
    public void deleteoperadores(int id_o) {
        Optional<Operadores> operadorFound = operadoresRepo.findById(id_o);
        if (operadorFound.isPresent()) {
            String correo = operadorFound.get().getO_correo();
            if (correo != null && !correo.trim().isEmpty()) {
                usuariosRepo.deleteByUs_correo(correo);
            }
            operadoresRepo.deleteById(id_o);
        }
    }

    @Transactional
    public Operadores saveOperador(Operadores operador) {
        // Hasheo de contraseña entrante
        if (operador.getO_contrasena() != null && !operador.getO_contrasena().trim().isEmpty()) {
            operador.setO_contrasena(passwordEncoder.encode(operador.getO_contrasena()));
        }
        
        // 1. Guardar el operador
        Operadores nuevoOp = operadoresRepo.save(operador);

        // 2. Crear y guardar en la tabla usuarios replicando el hash
        Usuarios usuario = new Usuarios();
        usuario.setUs_nombre(operador.getO_nombre());
        usuario.setUs_matricula(operador.getO_matricula());
        usuario.setUs_correo(operador.getO_correo());
        usuario.setUs_contrasena(operador.getO_contrasena()); 

        if (operador.getO_telefono() != null) {
            usuario.setUs_telefono(Long.valueOf(operador.getO_telefono()));
        }
        usuario.setUs_tipo("operador");
        usuariosRepo.save(usuario);

        return nuevoOp;
    }
}