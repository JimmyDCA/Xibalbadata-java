package com.iitca.tecnodesarrollo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iitca.tecnodesarrollo.dto.Alertas_pozos;

public interface Alertas_pozosRepo extends JpaRepository<Alertas_pozos, Integer> {
        public List<Alertas_pozos> findByIdLp(int idLp);

}