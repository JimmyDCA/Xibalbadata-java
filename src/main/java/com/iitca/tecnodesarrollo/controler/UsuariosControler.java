	package com.iitca.tecnodesarrollo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iitca.tecnodesarrollo.dto.Usuarios;
import com.iitca.tecnodesarrollo.service.UsuariosService;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin("*")
public class UsuariosControler {

	//desde aqui
	
	@Autowired
	private UsuariosService usuariosService;
	
	@GetMapping
	public ResponseEntity<?> getAllusuarios(){
		System.out.println("Estoy en el Get All");
		return ResponseEntity.ok(usuariosService.listAll());
	}
	
	@GetMapping("/{id_us}")
	public ResponseEntity<?> getusuariosById(@PathVariable int id_us){
		return ResponseEntity.ok(usuariosService.getusuariosByid(id_us));
	}
	
	//hasta aqui
	
	@PostMapping
	public ResponseEntity<Usuarios> addusuarios(@RequestBody Usuarios usuarios){
		System.out.println("En el post");
		System.out.println(usuarios.getUs_nombre());
        System.out.println(usuarios.getUs_correo());
        System.out.println(usuarios.getUs_contrasena());
        System.out.println(usuarios.getUs_telefono());
        System.out.println(usuarios.getUs_tipo());
		return new ResponseEntity<>(usuariosService.saveusuarios(usuarios),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id_us}")
	public ResponseEntity<Usuarios> updateusuarios(@RequestBody Usuarios usuarios, @PathVariable int id_us){
		return new ResponseEntity<Usuarios>(usuariosService.updateusuarios(id_us, usuarios),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id_us}")
	public ResponseEntity<?> deleteusuarios(@PathVariable int id_us){
		usuariosService.deleteusuarios(id_us);
		return ResponseEntity.ok("Se elimino");
	}
}
