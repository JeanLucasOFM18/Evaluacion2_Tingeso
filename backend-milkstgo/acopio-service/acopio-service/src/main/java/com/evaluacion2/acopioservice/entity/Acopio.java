package com.evaluacion2.acopioservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "acopios")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Acopio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date fecha;
    private String turno;
    private String proveedor;
    private String kilos;

}
