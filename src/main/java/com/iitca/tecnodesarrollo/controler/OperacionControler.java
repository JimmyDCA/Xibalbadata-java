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

import com.iitca.tecnodesarrollo.dto.Operacion;
import com.iitca.tecnodesarrollo.service.OperacionService;

@RestController
@RequestMapping("/api/operacion")
@CrossOrigin("*")
public class OperacionControler {

	//desde aqui
	
	@Autowired
	private OperacionService operacionService;
	
	@GetMapping
	public ResponseEntity<?> getAlloperacion(){
		System.out.println("Estoy en el Get All");
		return ResponseEntity.ok(operacionService.listAll());
	}
	
	@GetMapping("/{id_op}")
	public ResponseEntity<?> getoperacionById(@PathVariable int id_op){
		return ResponseEntity.ok(operacionService.getoperacionByid(id_op));
	}
	
	@GetMapping("/pozo/{id_lp}")
	public ResponseEntity<?> getoperacionByIdPozo(@PathVariable int id_lp){
		return ResponseEntity.ok(operacionService.getoperacionByIdPozo(id_lp));
	}
	//hasta aqui
	
	@PostMapping
	public ResponseEntity<Operacion> addoperacion(@RequestBody Operacion operacion){
		System.out.println("En el post");
		System.out.println(operacion.getOp_cpozo());
		System.out.println(operacion.getOp_fecha_captura());
		System.out.println(operacion.getOp_operador());
		System.out.println(operacion.getOp_nestatico());
		System.out.println(operacion.getOp_ndinamico());
        System.out.println(operacion.getOp_gasto());
        System.out.println(operacion.getOp_presion());
        System.out.println(operacion.getOp_tiempo_op());
        System.out.println(operacion.getOp_observaciones());
		return new ResponseEntity<>(operacionService.saveoperacion(operacion),HttpStatus.CREATED);
	}
	
	@PutMapping("/{id_op}")
	public ResponseEntity<Operacion> updateoperacion(@RequestBody Operacion operacion, @PathVariable int id_op){
		return new ResponseEntity<Operacion>(operacionService.updateoperacion(id_op, operacion),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id_op}")
	public ResponseEntity<?> deleteoperacion(@PathVariable int id_op){
		operacionService.deleteoperacion(id_op);
		return ResponseEntity.ok("Se elimino");
	}
}
