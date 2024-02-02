package com.corenetworks.ProyectoFinal.servicio;

import com.corenetworks.ProyectoFinal.modelo.Mensaje;

import java.util.List;

public interface IMensajeServicio extends ICRUD <Mensaje, Integer> {
    List<Mensaje> filtroMensajesporId(int id);
}
