package com.iitca.tecnodesarrollo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iitca.tecnodesarrollo.dto.Operacion;
import java.util.List;


public interface OperacionRepo extends JpaRepository<Operacion, Integer> {

    public List<Operacion> findByIdLp(int idLp);
}