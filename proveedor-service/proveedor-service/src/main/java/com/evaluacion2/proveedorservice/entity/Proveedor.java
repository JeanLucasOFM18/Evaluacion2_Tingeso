package com.evaluacion2.proveedorservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "proveedores")
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
