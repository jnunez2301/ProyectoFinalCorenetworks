package com.corenetworks.ProyectoFinal.servicio;

import com.corenetworks.ProyectoFinal.modelo.Usuario;

import java.util.List;

public interface IUsuarioServicio {
    List<Usuario> mostrarTodos();
    Usuario mostrarUno(int id);
    Usuario insertarUno(Usuario u);
    Usuario modificarUno(Usuario u);

}
