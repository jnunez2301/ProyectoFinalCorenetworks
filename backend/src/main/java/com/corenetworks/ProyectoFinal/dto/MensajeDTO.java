package com.corenetworks.ProyectoFinal.dto;

import com.corenetworks.ProyectoFinal.modelo.Mensaje;
import com.corenetworks.ProyectoFinal.modelo.Usuario;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class MensajeDTO {
    private int idMensaje;
    private LocalDate fCreacion;
    private String contenido;
    private String urlFotos;
    private LocalTime hCreacion;

    public Mensaje castMensaje(){
        Mensaje m1= new Mensaje();
        m1.setIdMensaje(idMensaje);
        m1.setFCreacion(fCreacion);
        m1.setContenido(contenido);
        m1.setUrlFotos(urlFotos);
        m1.setHCreacion(hCreacion);
        return m1;
    }
    public  MensajeDTO castUsuarioDTO(Mensaje m){
        idMensaje= m.getIdMensaje();
        fCreacion=m.getFCreacion();
        contenido=m.getContenido();
        urlFotos=m.getUrlFotos();
        hCreacion=m.getHCreacion();
        return this;
    }
}
