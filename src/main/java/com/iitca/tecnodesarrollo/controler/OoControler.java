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

import com.iitca.tecnodesarrollo.dto.Oo;
import com.iitca.tecnodesarrollo.service.OoService;

@RestController
@RequestMapping("/api/oo")
@CrossOrigin("*")
public class OoControler {

	//desde aqui
	
	@Autowired
	private OoService ooService;
	
	@GetMapping
	public ResponseEntity<?> getAlloo(){
		System.out.println("Estoy en el Get All");
		return ResponseEntity.ok(ooService.listAll());
	}
	
	@GetMapping("/{id_oo}")
	public ResponseEntity<?> getooById(@PathVariable int id_oo){
		return ResponseEntity.ok(ooService.getooByid(id_oo));
	}
	
	//hasta aqui
	
	@PostMapping
	public ResponseEntity<Oo> addoo(@RequestBody Oo oo){
		System.out.println("En el post");
		System.out.println(oo.getOo_acu_clave());
        System.out.println(oo.getOo_nombre());
        System.out.println(oo.getOo_descripcion());
        //System.out.println(oo.getOo_documentos());

		return new ResponseEntity<>(ooService.saveoo(oo),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id_oo}")
	public ResponseEntity<Oo> updateoo(@RequestBody Oo oo, @PathVariable int id_oo){
		return new ResponseEntity<Oo>(ooService.updateoo(id_oo, oo),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id_oo}")
	public ResponseEntity<?> deleteoo(@PathVariable int id_oo){
		ooService.deleteoo(id_oo);
		return ResponseEntity.ok("Se elimino");
	}
}
