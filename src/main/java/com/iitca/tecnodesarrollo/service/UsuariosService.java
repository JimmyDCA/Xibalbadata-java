package com.iitca.tecnodesarrollo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.iitca.tecnodesarrollo.dto.Usuarios;
import com.iitca.tecnodesarrollo.repo.UsuariosRepo;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepo usuariosRepo;

    // Herramienta de Spring Security para cifrar y comparar contraseñas
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public List<Usuarios> listAll(){
        return usuariosRepo.findAll();
    }
    
    public Object getusuariosByid(int id_us) {
        return usuariosRepo.findById(id_us);
    }
    
    // REGISTRO DE USUARIOS
    public Usuarios saveusuarios(Usuarios usuarios) {
        // 1. Evitar NullPointerException al cifrar
        if (usuarios.getUs_contrasena() != null && !usuarios.getUs_contrasena().trim().isEmpty()) {
            usuarios.setUs_contrasena(passwordEncoder.encode(usuarios.getUs_contrasena()));
        }

        // 2. Garantizar rol por defecto si viene vacío
        if (usuarios.getUs_tipo() == null || usuarios.getUs_tipo().trim().isEmpty()) {
            usuarios.setUs_tipo("administrador");
        }

        return usuariosRepo.save(usuarios);
    }
    
    // ACTUALIZACIÓN DE USUARIOS
    public Usuarios updateusuarios(int id_us, Usuarios usuariosToUpate) {
        Optional<Usuarios> usuariosFound = usuariosRepo.findById(id_us);
        if (usuariosFound.isPresent()) {
            Usuarios usuariosFoundToUpdate = usuariosFound.get();
            usuariosFoundToUpdate.setUs_nombre(usuariosToUpate.getUs_nombre());
            usuariosFoundToUpdate.setUs_correo(usuariosToUpate.getUs_correo());

            // Solo si enviaron una contraseña nueva se vuelve a cifrar
            if (usuariosToUpate.getUs_contrasena() != null && !usuariosToUpate.getUs_contrasena().isEmpty()) {
                String nuevoHash = passwordEncoder.encode(usuariosToUpate.getUs_contrasena());
                usuariosFoundToUpdate.setUs_contrasena(nuevoHash);
            }

            usuariosFoundToUpdate.setUs_telefono(usuariosToUpate.getUs_telefono());
            usuariosFoundToUpdate.setUs_tipo(usuariosToUpate.getUs_tipo());
            return usuariosRepo.save(usuariosFoundToUpdate);
        } else {
            return null;
        }
    }
    
    // INICIO DE SESIÓN (LOGIN)
    public boolean loginUsuario(String correo, String contrasenaIngresada) {
        Optional<Usuarios> usuarioOpt = usuariosRepo.findByUs_correo(correo);
        if (usuarioOpt.isPresent()) {
            return passwordEncoder.matches(contrasenaIngresada, usuarioOpt.get().getUs_contrasena());
        }
        return false;
    }

    // AUTENTICACIÓN DE USUARIOS (DEVUELVE EL OBJETO USUARIO SI ES EXITOSA)
    public Optional<Usuarios> autenticar(String correo, String contrasenaIngresada) {
        Optional<Usuarios> usuarioOpt = usuariosRepo.findByUs_correo(correo);
        
        if (usuarioOpt.isPresent()) {
            Usuarios usuario = usuarioOpt.get();
            // Compara contraseña en texto plano contra el hash BCrypt de la BD
            if (passwordEncoder.matches(contrasenaIngresada, usuario.getUs_contrasena())) {
                return Optional.of(usuario);
            }
        }
        return Optional.empty();
    }
    
    public void deleteusuarios(int id_us) {
        usuariosRepo.deleteById(id_us);
    }
}