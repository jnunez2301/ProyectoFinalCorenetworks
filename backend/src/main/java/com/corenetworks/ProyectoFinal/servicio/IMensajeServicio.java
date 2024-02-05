package com.corenetworks.ProyectoFinal.servicio;

import com.corenetworks.ProyectoFinal.modelo.Mensaje;

import java.util.List;
import java.util.Objects;

public interface IMensajeServicio extends ICRUD <Mensaje, Integer> {
    List<Object[]> filtroMensajesporId(int id) throws Exception;

    List<Object[]> ultimos5mensajes(int id) throws Exception;
}
