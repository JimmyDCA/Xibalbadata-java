package com.iitca.tecnodesarrollo.repo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iitca.tecnodesarrollo.dto.Usuarios;

@Repository
public interface UsuariosRepo extends JpaRepository<Usuarios, Integer> {

    @Query("SELECT u FROM Usuarios u WHERE u.us_correo = :correo")
    Optional<Usuarios> findByUs_correo(@Param("correo") String correo);

}