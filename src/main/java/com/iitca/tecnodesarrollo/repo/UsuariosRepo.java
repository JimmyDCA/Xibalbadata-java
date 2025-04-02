package com.iitca.tecnodesarrollo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iitca.tecnodesarrollo.dto.Usuarios;

public interface UsuariosRepo extends JpaRepository<Usuarios, Integer> {

}