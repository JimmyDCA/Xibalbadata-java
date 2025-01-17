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

import com.iitca.tecnodesarrollo.dto.Operadores;
import com.iitca.tecnodesarrollo.service.OperadoresService;

@RestController
@RequestMapping("/api/operadores")
@CrossOrigin("*")
public class OperadoresControler {

	//desde aqui
	
	@Autowired
	private OperadoresService operadoresService;
	
	@GetMapping
	public ResponseEntity<?> getAllopeadores(){
		System.out.println("Estoy en el Get All");
		return ResponseEntity.ok(operadoresService.listAll());
	}
	
	@GetMapping("/{o_nombre}")
	public ResponseEntity<?> getoperadoresById(@PathVariable String o_nombre){
		return ResponseEntity.ok(operadoresService.getoperadoresByo_nombre(o_nombre));
	}
	
	//hasta aqui
	
	@PostMapping
	public ResponseEntity<Operadores> addoperadores(@RequestBody Operadores operadores){
		System.out.println("En el post");
		System.out.println(operadores.getO_nombre());
        System.out.println(operadores.getO_correo());
        System.out.println(operadores.getO_contrasena());
        System.out.println(operadores.getO_telefono());
		return new ResponseEntity<>(operadoresService.saveoperadores(operadores),HttpStatus.CREATED);
	}
	
	@PutMapping("/{o_nombre}")
	public ResponseEntity<Operadores> updateoperadores(@RequestBody Operadores operadores, @PathVariable String o_nombre){
		return new ResponseEntity<Operadores>(operadoresService.updateoperadores(o_nombre, operadores),HttpStatus.OK);
	}
	
	@DeleteMapping("/{o_nombre}")
	public ResponseEntity<?> deleteoperadores(@PathVariable String o_nombre){
		operadoresService.deleteoperadores(o_nombre);
		return ResponseEntity.ok("Se elimino");
	}
}
