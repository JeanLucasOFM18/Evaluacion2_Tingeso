package com.evaluacion2.proveedorservice.controller;

import com.evaluacion2.proveedorservice.entity.Proveedor;
import com.evaluacion2.proveedorservice.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

//@Controller
@RestController
@RequestMapping("/proveedor")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorServices;

    /*
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/registro")
    public String registro(){
        return "registro";
    }*/

    @GetMapping("/listado")
    public ResponseEntity<List<Proveedor>> mostrarUsuarios() {
        List<Proveedor> proveedores = proveedorServices.listadoProveedores();
        if(proveedores.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(proveedores);
    }

    @GetMapping("/contarTurnos/{codigo}")
    public ResponseEntity<Proveedor> obtenerPorCodigo(@PathVariable("codigo") String codigo) {
        Proveedor proveedor = proveedorServices.obtenerPorCodigo(codigo);
        return ResponseEntity.ok(proveedor);
    }

    @PostMapping("/crear")
    public String crearProveedor(@RequestBody Proveedor proveedor){
        if(proveedorServices.findByCodigo(proveedor.getCodigo())){
            return "Ya esta registrado este codigo";
        }
        else {
            Proveedor proveedornew = proveedorServices.crearProveedor(proveedor);
            if(proveedornew!=null){
                return "Registro Exitoso";
            }
            else {
                return "Registro Fallido";
            }
        }
    }

    /*
    @PostMapping("/crearProveedor")
    public String crearProveedor(@ModelAttribute Proveedor proveedor, RedirectAttributes redirectAttributes){
        if(proveedorServices.findByCodigo(proveedor.getCodigo())){
            redirectAttributes.addFlashAttribute("mensaje", "Ya esta registrado este codigo");
        }
        else {
            Proveedor proveedornew = proveedorServices.crearProveedor(proveedor);
            if(proveedornew!=null){
                redirectAttributes.addFlashAttribute("mensaje", "Registro Exitoso");
            }
            else {
                System.out.println("Registro Fallido");
            }
        }
        return "redirect:/registro";
    }

    @GetMapping("/proveedores")
    public String mostrarUsuarios(Model model) {
        List<Proveedor> proveedores = proveedorServices.listadoProveedores();
        model.addAttribute("proveedores", proveedores);
        return "proveedores";
    }*/


}
