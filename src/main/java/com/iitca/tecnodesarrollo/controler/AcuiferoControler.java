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

import com.iitca.tecnodesarrollo.dto.Acuifero;
import com.iitca.tecnodesarrollo.service.AcuiferoService;

@RestController
@RequestMapping("/api/acuifero")
@CrossOrigin("*")
public class AcuiferoControler {

	//desde aqui
	
	@Autowired
	private AcuiferoService acuiferoService;
	
	@GetMapping
	public ResponseEntity<?> getAllacuifero(){
		System.out.println("Estoy en el Get All");
		return ResponseEntity.ok(acuiferoService.listAll());
	}
	
	@GetMapping("/{Acu_clave}")
	public ResponseEntity<?> getPozoById(@PathVariable Integer Acu_clave){
		return ResponseEntity.ok(acuiferoService.getacuiferoByAcu_clave(Acu_clave));
	}
	
	//hasta aqui
	
	@PostMapping
	public ResponseEntity<Acuifero> addacuifero(@RequestBody Acuifero acuifero){
		System.out.println("En el post");
		System.out.println(acuifero.getAcu_clave());
		System.out.println(acuifero.getAcu_nombre());
		System.out.println(acuifero.getAcu_descripcion());
		//System.out.println(acuifero.getAcu_limites());
		System.out.println(acuifero.getAcu_num_op());
		return new ResponseEntity<>(acuiferoService.saveacuifero(acuifero),HttpStatus.CREATED);
	}
	
	@PutMapping("/{Acu_clave}")
	public ResponseEntity<Acuifero> updateacuifero(@RequestBody Acuifero acuifero, @PathVariable Integer Acu_clave){
		return new ResponseEntity<Acuifero>(acuiferoService.updateacuifero(Acu_clave, acuifero),HttpStatus.OK);
	}
	
	@DeleteMapping("/{Acu_clave}")
	public ResponseEntity<?> deleteacuifero(@PathVariable Integer Acu_clave){
		acuiferoService.deleteacuifero(Acu_clave);
		return ResponseEntity.ok("Se elimino");
	}
}
