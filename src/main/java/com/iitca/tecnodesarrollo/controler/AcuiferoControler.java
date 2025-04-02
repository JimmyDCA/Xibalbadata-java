package com.iitca.tecnodesarrollo.controler;

import java.io.IOException;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	
	@GetMapping("/{id_acu}")
	public ResponseEntity<?> getacuiferoById(@PathVariable int id_acu){
		return ResponseEntity.ok(acuiferoService.getacuiferoByid(id_acu));
	}
	
	//hasta aqui
	
	@PostMapping
	public ResponseEntity<Acuifero> addacuifero(@RequestBody Acuifero acuifero,@RequestParam("limites") MultipartFile acu_limites) throws IOException{
		System.out.println("En el post");
		System.out.println(acuifero.getAcu_clave());
		System.out.println(acuifero.getAcu_nombre());
		System.out.println(acuifero.getAcu_descripcion());
		System.out.println(acuifero.getAcu_num_op());
		Acuifero acu_completo = new Acuifero();
		acu_completo.setAcu_clave(acuifero.getAcu_clave());
		acu_completo.setAcu_nombre(acuifero.getAcu_nombre());
		acu_completo.setAcu_descripcion(acuifero.getAcu_nombre());
		acu_completo.setAcu_limites(acu_limites.getBytes());
		acu_completo.setAcu_num_op(acuifero.getAcu_num_op());
		return new ResponseEntity<>(acuiferoService.saveacuifero(acu_completo),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id_acu}")
	public ResponseEntity<Acuifero> updateacuifero(@RequestBody Acuifero acuifero, @PathVariable int id_acu){
		return new ResponseEntity<Acuifero>(acuiferoService.updateacuifero(id_acu, acuifero),HttpStatus.OK);
	}
	
	@DeleteMapping("/{Acu_clave}")
	public ResponseEntity<?> deleteacuifero(@PathVariable int id_acu){
		acuiferoService.deleteacuifero(id_acu);
		return ResponseEntity.ok("Se elimino");
	}
}
