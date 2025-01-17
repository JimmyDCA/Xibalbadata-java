package com.iitca.tecnodesarrollo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iitca.tecnodesarrollo.dto.Operacion;

public interface OperacionRepo extends JpaRepository<Operacion, String> {

}