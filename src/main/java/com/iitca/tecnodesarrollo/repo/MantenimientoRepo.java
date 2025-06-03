package com.iitca.tecnodesarrollo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iitca.tecnodesarrollo.dto.Mantenimiento;


public interface MantenimientoRepo extends JpaRepository<Mantenimiento, Integer> {
        public List<Mantenimiento> findByIdLp(int idLp);
}

