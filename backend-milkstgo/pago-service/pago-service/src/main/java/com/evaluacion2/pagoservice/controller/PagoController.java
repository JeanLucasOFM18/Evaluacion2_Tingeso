package com.evaluacion2.pagoservice.controller;

import com.evaluacion2.pagoservice.entity.Pagos;
import com.evaluacion2.pagoservice.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pago")
public class PagoController {

    @Autowired
    private PagoService pagosService;

    @GetMapping("/calculos")
    public ResponseEntity<List<Pagos>> mostrarCalculos() {
        pagosService.obtencionDatos();
        List<Pagos> calculos = pagosService.findAll();
        return ResponseEntity.ok(calculos);
    }

}
