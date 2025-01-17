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

import com.iitca.tecnodesarrollo.dto.Alertas_pozos;
import com.iitca.tecnodesarrollo.service.Alertas_pozosService;

@RestController
@RequestMapping("/api/alertas_pozos")
@CrossOrigin("*")
public class Alertas_pozosControler {

	//desde aqui
	
	@Autowired
	private Alertas_pozosService alertas_pozosService;
	
	@GetMapping
	public ResponseEntity<?> getAllalertas_pozos(){
		System.out.println("Estoy en el Get All");
		return ResponseEntity.ok(alertas_pozosService.listAll());
	}
	
	@GetMapping("/{Al_Clave_de_pozo}")
	public ResponseEntity<?> getPozoById(@PathVariable String Al_Clave_de_pozo){
		return ResponseEntity.ok(alertas_pozosService.getalertas_pozosByAl_Clave_de_pozo(Al_Clave_de_pozo));
	}
	
	//hasta aqui
	
	@PostMapping
	public ResponseEntity<Alertas_pozos> addalertas_pozos(@RequestBody Alertas_pozos alertas_pozos){
		System.out.println("En el post");
		System.out.println(alertas_pozos.getAl_Clave_de_pozo());
		//System.out.println(alertas_pozos.getAl_Fecha_de_captura());
		System.out.println(alertas_pozos.getAl_Tipo_de_alerta());
		System.out.println(alertas_pozos.getAl_comentarios());
		return new ResponseEntity<>(alertas_pozosService.savealertas_pozos(alertas_pozos),HttpStatus.CREATED);
	}
	
	@PutMapping("/{Al_Clave_de_pozo}")
	public ResponseEntity<Alertas_pozos> updatealertas_pozos(@RequestBody Alertas_pozos alertas_pozos, @PathVariable String Al_Clave_de_pozo){
		return new ResponseEntity<Alertas_pozos>(alertas_pozosService.updatealertas_pozos(Al_Clave_de_pozo, alertas_pozos),HttpStatus.OK);
	}
	
	@DeleteMapping("/{Al_Clave_de_pozo}")
	public ResponseEntity<?> deletealertas_pozos(@PathVariable String Al_Clave_de_pozo){
		alertas_pozosService.deletealertas_pozos(Al_Clave_de_pozo);
		return ResponseEntity.ok("Se elimino");
	}
}