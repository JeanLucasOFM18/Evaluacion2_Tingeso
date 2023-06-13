package com.evaluacion2.porcentajeservice.service;

import com.evaluacion2.porcentajeservice.entity.Porcentaje;
import com.evaluacion2.porcentajeservice.repository.PorcentajeRepository;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class PorcentajeService {

    @Autowired
    private PorcentajeRepository porcentajeRepository;

    private final Logger logg = (Logger) LoggerFactory.getLogger(PorcentajeService.class);

    public List<Porcentaje> obtenerData(){
        return porcentajeRepository.findAll();
    }

    @Generated
    public String guardar(MultipartFile file){
        String filename = file.getOriginalFilename();
        if(filename != null){
            if(!file.isEmpty()){
                try{
                    byte [] bytes = file.getBytes();
                    Path path  = Paths.get(file.getOriginalFilename());
                    Files.write(path, bytes);
                    logg.info("Archivo guardado");
                }
                catch (IOException e){
                    logg.error("ERROR", e);
                }
            }
            return "Archivo guardado con exito!";
        }
        else{
            return "No se pudo guardar el archivo";
        }
    }

    @Generated
    public void leerCsv(String direccion){
        String texto = "";
        BufferedReader bf = null;
        porcentajeRepository.deleteAll();
        try{
            bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            int count = 1;
            while((bfRead = bf.readLine()) != null){
                if (count == 1){
                    count = 0;
                }
                else{
                    guardarDataDB(bfRead.split(";")[0], bfRead.split(";")[1], bfRead.split(";")[2]);
                    temp = temp + "\n" + bfRead;
                }
            }
            texto = temp;
            System.out.println("Archivo leido exitosamente");
        }catch(Exception e){
            System.err.println("No se encontro el archivo");
        }finally{
            if(bf != null){
                try{
                    bf.close();
                }catch(IOException e){
                    logg.error("ERROR", e);
                }
            }
        }
    }

    public void guardarData(Porcentaje data){
        porcentajeRepository.save(data);
    }

    public void guardarDataDB(String proveedor, String grasa, String solidos){
        Porcentaje newData = new Porcentaje();
        newData.setProveedor(proveedor);
        newData.setGrasa(grasa);
        newData.setSolidototal(solidos);
        guardarData(newData);
    }

    public void eliminarData(List<Porcentaje> datas){
        porcentajeRepository.deleteAll(datas);
    }

    public Porcentaje findByProveedor(String codigo){
        return porcentajeRepository.findByProveedor(codigo);
    }
}
