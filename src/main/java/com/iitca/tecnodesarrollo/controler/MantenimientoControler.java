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

import com.iitca.tecnodesarrollo.dto.Mantenimiento;
import com.iitca.tecnodesarrollo.service.MantenimientoService;

@RestController
@RequestMapping("/api/mantenimiento")
@CrossOrigin("*")
public class MantenimientoControler {

	//desde aqui
	
	@Autowired
	private MantenimientoService mantenimientoService;
	
	@GetMapping
	public ResponseEntity<?> getAllmantenimiento(){
		System.out.println("Estoy en el Get All");
		return ResponseEntity.ok(mantenimientoService.listAll());
	}
	
	@GetMapping("/{mtto_clave_pozo}")
	public ResponseEntity<?> getmantenimientoById(@PathVariable String mtto_clave_pozo){
		return ResponseEntity.ok(mantenimientoService.getmantenimientoByMtto_clave_pozo(mtto_clave_pozo));
	}
	
	//hasta aqui
	
	@PostMapping
	public ResponseEntity<Mantenimiento> addmantenimiento(@RequestBody Mantenimiento mantenimiento){
		System.out.println("En el post");
		System.out.println(mantenimiento.getMtto_clave_pozo());
        System.out.println(mantenimiento.getMtto_fecha_captura());
        System.out.println(mantenimiento.getMtto_motor_tipo());
        System.out.println(mantenimiento.getMtto_motor_hp());
        System.out.println(mantenimiento.getMtto_motor_kw());
        System.out.println(mantenimiento.getMtto_motor_eficiencia());
        System.out.println(mantenimiento.getMtto_tablero_tipo());
        System.out.println(mantenimiento.getMtto_tablero_capacidad());
        System.out.println(mantenimiento.getMtto_transformador_tipo());
        System.out.println(mantenimiento.getMtto_transformador_tipo());
        System.out.println(mantenimiento.getMtto_cable_calibre());
        System.out.println(mantenimiento.getMtto_cable_longitud());
		System.out.println(mantenimiento.getMtto_tuberia_diametro());
		System.out.println(mantenimiento.getMtto_tuberia_longitud());
		System.out.println(mantenimiento.getMtto_observaciones());

		return new ResponseEntity<>(mantenimientoService.savemantenimiento(mantenimiento),HttpStatus.CREATED);
	}
	
	@PutMapping("/{mtto_clave_pozo}")
	public ResponseEntity<Mantenimiento> updatemantenimiento(@RequestBody Mantenimiento mantenimiento, @PathVariable String mtto_clave_pozo){
		return new ResponseEntity<Mantenimiento>(mantenimientoService.updatemantenimiento(mtto_clave_pozo, mantenimiento),HttpStatus.OK);
	}
	
	@DeleteMapping("/{mtto_clave_pozo}")
	public ResponseEntity<?> deletemantenimiento(@PathVariable String mtto_clave_pozo){
		mantenimientoService.deletemantenimiento(mtto_clave_pozo);
		return ResponseEntity.ok("Se elimino");
	}
}
