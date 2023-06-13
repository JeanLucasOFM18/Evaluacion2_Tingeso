package com.evaluacion2.acopioservice.service;

import com.evaluacion2.acopioservice.entity.Acopio;
import com.evaluacion2.acopioservice.repository.AcopioRepository;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AcopioService {

    @Autowired
    private AcopioRepository acopioRepository;

    private final Logger logg = (Logger) LoggerFactory.getLogger(AcopioService.class);

    public List<Acopio> obtenerData(){
        return acopioRepository.findAll();
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
        SimpleDateFormat formatter = new SimpleDateFormat("yy/MM/dd");
        BufferedReader bf = null;
        acopioRepository.deleteAll();
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
                    guardarDataDB(formatter.parse(bfRead.split(";")[0]), bfRead.split(";")[1], bfRead.split(";")[2], bfRead.split(";")[3]);
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

    public void guardarData(Acopio data){
        acopioRepository.save(data);
    }

    public void guardarDataDB(Date fecha, String turno, String proveedor, String kls_leche){
        Acopio newData = new Acopio();
        newData.setFecha(fecha);
        newData.setTurno(turno);
        newData.setProveedor(proveedor);
        newData.setKilos(kls_leche);
        guardarData(newData);
    }

    public void eliminarData(List<Acopio> datas){
        acopioRepository.deleteAll(datas);
    }

    public List<Acopio> findByProveedor (String codigo){
        return acopioRepository.findByProveedor(codigo);
    }

    public List<Date> findAllDistinctDates(String codigo){
        return acopioRepository.findAllDistinctDates(codigo);
    }

    public List<Date> findAllByFecha(String codigo){
        return acopioRepository.findAllByFecha(codigo);
    }

    public List<Date> contarTurnos(String codigo, String turno){
        return acopioRepository.contarTurnos(codigo, turno);
    }
}