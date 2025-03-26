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

import com.iitca.tecnodesarrollo.dto.Lista_pozos;
import com.iitca.tecnodesarrollo.service.Lista_pozosService;

@RestController
@RequestMapping("/api/lista_pozos")
@CrossOrigin("*")
public class Lista_pozosControler {

	//desde aqui
	
	@Autowired
	private Lista_pozosService lista_pozosService;
	
	@GetMapping
	public ResponseEntity<?> getAlllista_pozos(){
		System.out.println("Estoy en el Get All");
		return ResponseEntity.ok(lista_pozosService.listAll());
	}
	
	@GetMapping("/{L_poz_Clave}")
	public ResponseEntity<?> getlista_pozosById(@PathVariable String L_poz_Clave){
		return ResponseEntity.ok(lista_pozosService.getlista_pozosByL_poz_Clave(L_poz_Clave));
	}
	
	//hasta aqui
	
	@PostMapping
	public ResponseEntity<Lista_pozos> addlista_pozos(@RequestBody Lista_pozos lista_pozos){
		System.out.println("En el post");
		System.out.println(lista_pozos.getL_poz_clave());
		System.out.println(lista_pozos.getLp_Nombre());
		System.out.println(lista_pozos.getLp_ramal());
		//System.out.println(lista_pozos.getLp_Ubicación());
		System.out.println(lista_pozos.getLp_Profundidad_perforación());
		System.out.println(lista_pozos.getLp_Diámetro_perforación());
		System.out.println(lista_pozos.getLp_Diámetro_ADEME());
       // System.out.println(lista_pozos.getLp_Documentos());

		return new ResponseEntity<>(lista_pozosService.savelista_pozos(lista_pozos),HttpStatus.CREATED);
	}
	
	@PutMapping("/{L_poz_Clave}")
	public ResponseEntity<Lista_pozos> updatelista_pozos(@RequestBody Lista_pozos lista_pozos, @PathVariable String L_poz_Clave){
		return new ResponseEntity<Lista_pozos>(lista_pozosService.updatelista_pozos(L_poz_Clave, lista_pozos),HttpStatus.OK);
	}
	
	@DeleteMapping("/{L_poz_Clave}")
	public ResponseEntity<?> deletelista_pozos(@PathVariable String L_poz_Clave){
		lista_pozosService.deletelista_pozos(L_poz_Clave);
		return ResponseEntity.ok("Se elimino");
	}
}
