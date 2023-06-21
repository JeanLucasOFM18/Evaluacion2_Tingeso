package com.evaluacion2.pagoservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Acopio {

    private Date fecha;
    private String turno;
    private String proveedor;
    private String kilos;

}