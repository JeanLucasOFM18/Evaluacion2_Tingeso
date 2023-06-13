package com.evaluacion2.proveedorservice.service;

import com.evaluacion2.proveedorservice.entity.Proveedor;
import com.evaluacion2.proveedorservice.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProveedorService{

    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> listadoProveedores() {
        return proveedorRepository.findAll();
    }

    public Proveedor crearProveedor(Proveedor proveedor) {
        return proveedorRepository.save(proveedor);
    }

    public Proveedor actualizarProveedor(Proveedor proveedor){
        return proveedorRepository.save(proveedor);
    }

    public void eliminarProveedor(Proveedor proveedor){
        proveedorRepository.delete(proveedor);
    }

    public boolean findByCodigo(String codigo) {
        Proveedor proveedor = proveedorRepository.findByCodigo(codigo);
        return proveedor != null;
    }

    public Proveedor obtenerPorCodigo(String codigo) {
        return proveedorRepository.findByCodigo(codigo);
    }
}
