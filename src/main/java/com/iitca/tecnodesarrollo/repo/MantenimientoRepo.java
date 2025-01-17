package com.iitca.tecnodesarrollo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iitca.tecnodesarrollo.dto.Mantenimiento;

public interface MantenimientoRepo extends JpaRepository<Mantenimiento, String> {

}