package com.evaluacion2.pagoservice.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Proveedor {

    @Id
    private String codigo;
    private String nombre;
    private String categoria;
    private String retencion;
}
