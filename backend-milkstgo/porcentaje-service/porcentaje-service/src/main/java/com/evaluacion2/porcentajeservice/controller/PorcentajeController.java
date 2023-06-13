package com.evaluacion2.porcentajeservice.controller;

import com.evaluacion2.porcentajeservice.entity.Porcentaje;
import com.evaluacion2.porcentajeservice.service.PorcentajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping("/porcentaje")
public class PorcentajeController {

    @Autowired
    private PorcentajeService porcentajeServices;

    /*
    @GetMapping("/porcentaje")
    public String main() {
        return "porcentaje";
    }
     */

    @GetMapping("/obtenerData")
    public ResponseEntity<List<Porcentaje>> obtenerData() {
        List<Porcentaje> porcentajes = porcentajeServices.obtenerData();
        if(porcentajes.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(porcentajes);
    }

    @GetMapping("/findByProveedor/{codigo}")
    public ResponseEntity<Porcentaje> findByProveedor(@PathVariable("codigo") String codigo) {
        Porcentaje porcentajes = porcentajeServices.findByProveedor(codigo);
        return ResponseEntity.ok(porcentajes);
    }

    @GetMapping("/prueba")
    public String prueba(){
        return "hola";
    }

    @PostMapping("/subir")
    public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        porcentajeServices.guardar(file);
        redirectAttributes.addFlashAttribute("mensaje", "¡Archivo cargado correctamente!");
        porcentajeServices.leerCsv("Porcentajes.csv");
        return "Archivo subido con exito";
    }

    /*
    @PostMapping("/porcentaje")
    public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        porcentajeServices.guardar(file);
        redirectAttributes.addFlashAttribute("mensaje", "¡Archivo cargado correctamente!");
        porcentajeServices.leerCsv("Porcentajes.csv");
        return "redirect:/porcentaje";
    }
    */
}
