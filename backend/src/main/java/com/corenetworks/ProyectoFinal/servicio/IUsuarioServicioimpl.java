package com.corenetworks.ProyectoFinal.servicio;

import com.corenetworks.ProyectoFinal.modelo.Usuario;
import com.corenetworks.ProyectoFinal.repositorio.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IUsuarioServicioimpl implements IUsuarioServicio{
    @Autowired
    private IUsuarioRepositorio repositorio;
    @Override
    public List<Usuario> mostrarTodos() {
        return repositorio.findAll();
    }

    @Override
    public Usuario mostrarUno(int id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public Usuario insertarUno(Usuario u) {
        return repositorio.save(u);
    }

    @Override
    public Usuario modificarUno(Usuario u) {
        return repositorio.save(u);
    }

}
