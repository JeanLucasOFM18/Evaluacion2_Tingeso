package com.evaluacion2.porcentajeservice.repository;

import com.evaluacion2.porcentajeservice.entity.Porcentaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PorcentajeRepository extends JpaRepository<Porcentaje, Integer> {

    @Query(value = "SELECT p FROM Porcentaje p WHERE p.proveedor = :filtro")
    Porcentaje findByProveedor(@Param("filtro") String filtro);
}
