package com.corenetworks.ProyectoFinal.servicio;

import com.corenetworks.ProyectoFinal.dto.PerfilDTO;
import com.corenetworks.ProyectoFinal.modelo.Perfil;

public interface IPerfilServicio extends ICRUD<Perfil,Long> {
    PerfilDTO datosPerfil(String nombreUsuario) throws Exception;


}
