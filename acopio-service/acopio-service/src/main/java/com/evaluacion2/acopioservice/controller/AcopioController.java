package com.evaluacion2.acopioservice.controller;

import com.evaluacion2.acopioservice.entity.Acopio;
import com.evaluacion2.acopioservice.service.AcopioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/acopio")
public class AcopioController {

    @Autowired
    private AcopioService acopioServices;

    /*
    @GetMapping("/acopio")
    public String main() {
        return "acopio";
    }
     */

    @GetMapping("/obtenerData")
    public ResponseEntity<List<Acopio>> obtenerData() {
        List<Acopio> acopios = acopioServices.obtenerData();
        if(acopios.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(acopios);
    }

    @GetMapping("/findByProveedor/{codigo}")
    public ResponseEntity<List<Acopio>> findByProveedor(@PathVariable("codigo") String codigo) {
        List<Acopio> acopios = acopioServices.findByProveedor(codigo);
        if(acopios.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(acopios);
    }

    @GetMapping("/findAllDistinctDates/{codigo}")
    public ResponseEntity<List<Date>> findAllDistinctDates(@PathVariable("codigo") String codigo) {
        List<Date> acopios = acopioServices.findAllDistinctDates(codigo);
        if(acopios.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(acopios);
    }

    @GetMapping("/findAllByFecha/{codigo}")
    public ResponseEntity<List<Date>> findAllByFecha(@PathVariable("codigo") String codigo) {
        List<Date> acopios = acopioServices.findAllByFecha(codigo);
        if(acopios.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(acopios);
    }

    @GetMapping("/contarTurnos/{codigo}/{turno}")
    public ResponseEntity<List<Date>> contarTurnos(@PathVariable("codigo") String codigo, @PathVariable("turno") String turno) {
        List<Date> acopios = acopioServices.contarTurnos(codigo, turno);
        if(acopios.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(acopios);
    }

    @GetMapping("/prueba")
    public String prueba(){
        return "hola";
    }

    @GetMapping
    @PostMapping("/subir")
    public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        acopioServices.guardar(file);
        redirectAttributes.addFlashAttribute("mensaje", "¡Archivo cargado correctamente!");
        acopioServices.leerCsv("Acopio.csv");
        return "Archivo subido con exito";
    }

    /*
    @PostMapping("/acopio")
    public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        acopioServices.guardar(file);
        redirectAttributes.addFlashAttribute("mensaje", "¡Archivo cargado correctamente!");
        acopioServices.leerCsv("Acopio.csv");
        return "redirect:/acopio";
    }
    */
}
