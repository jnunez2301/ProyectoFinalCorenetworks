package com.corenetworks.ProyectoFinal.servicio;

import com.corenetworks.ProyectoFinal.modelo.Usuario;

import java.util.List;

public interface IUsuarioServicio extends ICRUD <Usuario,Integer>{
    List<Usuario> seguidor(String nombreUsuario);
    Usuario BuscarPorNombreUsuario(String nombreUsuario);
    void seguirUsuario(String nombreUsuarioSeguidor, String nombreUsuarioSeguido);
}
