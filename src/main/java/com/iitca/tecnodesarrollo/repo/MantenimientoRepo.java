package com.iitca.tecnodesarrollo.repo;

import com.iitca.tecnodesarrollo.dto.Mantenimiento;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MantenimientoRepo extends JpaRepository<Mantenimiento, Integer> {

    @Query("SELECT m FROM Mantenimiento m WHERE m.mtto_clave_pozo = :clave ORDER BY m.mtto_fecha_captura DESC")
    List<Mantenimiento> buscarPorClave(@Param("clave") String clave, Pageable pageable);
}