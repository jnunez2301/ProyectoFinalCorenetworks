package com.corenetworks.ProyectoFinal.servicio;

import com.corenetworks.ProyectoFinal.dto.MensajeDTO;
import com.corenetworks.ProyectoFinal.dto.UsuarioDTO;
import com.corenetworks.ProyectoFinal.modelo.Mensaje;

import java.util.List;

public interface IMensajeServicio extends ICRUD <Mensaje, Integer> {
    List<MensajeDTO> filtroMensajesporId(int id) throws Exception;

    List<MensajeDTO> ultimos5mensajes(int id) throws Exception;
}
