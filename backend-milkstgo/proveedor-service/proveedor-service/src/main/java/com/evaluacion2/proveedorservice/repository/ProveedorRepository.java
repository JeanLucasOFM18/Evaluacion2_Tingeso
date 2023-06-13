package com.evaluacion2.proveedorservice.repository;

import com.evaluacion2.proveedorservice.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, String> {

    @Query(value = "SELECT p FROM Proveedor p WHERE p.codigo = :filtro")
    Proveedor findByCodigo(@Param("filtro") String filtro);
}
