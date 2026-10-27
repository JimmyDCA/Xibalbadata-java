package com.iitca.tecnodesarrollo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.iitca.tecnodesarrollo.dto.Operacion;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;



public interface OperacionRepo extends JpaRepository<Operacion, Integer> {

    List<Operacion> findByIdLp(int idLp);

    @Query("SELECT o FROM Operacion o WHERE o.idLp = :idLp ORDER BY o.op_fecha_captura DESC")
    List<Operacion> buscarPorPozo(@Param("idLp") int idLp, Pageable pageable);
}