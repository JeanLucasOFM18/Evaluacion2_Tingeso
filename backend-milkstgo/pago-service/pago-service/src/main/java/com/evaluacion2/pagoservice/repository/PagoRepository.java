package com.evaluacion2.pagoservice.repository;

import com.evaluacion2.pagoservice.entity.Pagos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PagoRepository extends JpaRepository<Pagos, Integer> {

    @Query(value = "SELECT p FROM Pagos p WHERE p.codigo_proveedor = :filtro")
    List<Pagos> findByCodigo_proveedor(@Param("filtro") String filtro);

    @Query("SELECT p FROM Pagos p WHERE p.codigo_proveedor = :proveedor AND p.quincena = :quincena")
    Pagos findByCodigo_proveedorAndQuincena(@Param("proveedor") String proveedor, @Param("quincena") String quincena);
}
