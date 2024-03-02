package com.corenetworks.ProyectoFinal.servicio.Impl;

import com.corenetworks.ProyectoFinal.dto.BuscarPorNombreDTO;
import com.corenetworks.ProyectoFinal.modelo.Usuario;
import com.corenetworks.ProyectoFinal.repositorio.IGeneralRepositorio;
import com.corenetworks.ProyectoFinal.repositorio.IUsuarioRepositorio;
import com.corenetworks.ProyectoFinal.servicio.IUsuarioServicio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IUsuarioServicioimpl extends ICRUDimpl <Usuario,Integer> implements IUsuarioServicio {
    @Autowired
    private IUsuarioRepositorio repositorio;

    @Override
    protected IGeneralRepositorio<Usuario, Integer> getRepo() {
        return repositorio;
    }

    @Override
    public List<Usuario> seguidor(String nombreUsuario) {
        return repositorio.BuscarSeguidor(nombreUsuario);
    }

    @Override
    public BuscarPorNombreDTO BuscarPorNombreUsuario(String nombreUsuario) {
        return repositorio.BuscarporNombreUsuario(nombreUsuario);
    }
    @Transactional
    public void seguirUsuario(String nombreUsuarioSeguidor, String nombreUsuarioSeguido) {
        Usuario seguidor =  repositorio.BuscarporNombreUsuario(nombreUsuarioSeguidor);
        Usuario seguido = repositorio.BuscarporNombreUsuario(nombreUsuarioSeguido);
        if (seguidor != null && seguido != null && !seguidor.equals(seguido)) {
            if (!seguidor.getSeguidores().contains(seguido)) {
                seguidor.getSeguidores().add(seguido);
                repositorio.save(seguidor);
            }
        }

    }

}
