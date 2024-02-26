package com.corenetworks.ProyectoFinal.servicio.Impl;

import com.corenetworks.ProyectoFinal.dto.UsuarioDTO;
import com.corenetworks.ProyectoFinal.modelo.Usuario;
import com.corenetworks.ProyectoFinal.repositorio.IGeneralRepositorio;
import com.corenetworks.ProyectoFinal.repositorio.IUsuarioRepositorio;
import com.corenetworks.ProyectoFinal.servicio.IUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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
    public List<UsuarioDTO> ultimos5mensajes(int id) throws Exception {
        return ultimos5mensajes(id);
    }
}
