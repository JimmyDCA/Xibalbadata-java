package com.iitca.tecnodesarrollo.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iitca.tecnodesarrollo.service.Alertas_tipoService;

@RestController
@RequestMapping("/api/alertas_tipo")
@CrossOrigin("*")
public class Alertas_tipoControler {

	//desde aqui
	
	@Autowired
	private Alertas_tipoService alertas_tipoService;
	
	@GetMapping
	public ResponseEntity<?> getAllalertas_tipo(){
		System.out.println("Estoy en el Get All");
		return ResponseEntity.ok(alertas_tipoService.listAll());
	}
	
	@GetMapping("/{id_alert}")
	public ResponseEntity<?> getoperadoresById(@PathVariable int id_alert){
		return ResponseEntity.ok(alertas_tipoService.getoperadoresByid(id_alert));
	}
	
	//hasta aqui
	
	}
