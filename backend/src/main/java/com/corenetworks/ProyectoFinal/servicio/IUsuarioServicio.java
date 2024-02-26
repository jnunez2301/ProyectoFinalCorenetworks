package com.corenetworks.ProyectoFinal.servicio;

import com.corenetworks.ProyectoFinal.dto.UsuarioDTO;
import com.corenetworks.ProyectoFinal.modelo.Mensaje;
import com.corenetworks.ProyectoFinal.modelo.Usuario;

import java.util.List;

public interface IUsuarioServicio extends ICRUD <Usuario,Integer>{
    List<UsuarioDTO> ultimos5mensajes(int id) throws Exception;

}
