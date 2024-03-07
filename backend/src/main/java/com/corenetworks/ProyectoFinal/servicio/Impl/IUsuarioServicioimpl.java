package com.corenetworks.ProyectoFinal.servicio.Impl;

import com.corenetworks.ProyectoFinal.dto.BuscarPorNombreDTO;
import com.corenetworks.ProyectoFinal.dto.SeguidorDTO;
import com.corenetworks.ProyectoFinal.modelo.Seguido;
import com.corenetworks.ProyectoFinal.modelo.Seguidor;
import com.corenetworks.ProyectoFinal.modelo.Usuario;
import com.corenetworks.ProyectoFinal.repositorio.IGeneralRepositorio;
import com.corenetworks.ProyectoFinal.repositorio.ISeguidoRepositorio;
import com.corenetworks.ProyectoFinal.repositorio.ISeguidorRepositorio;
import com.corenetworks.ProyectoFinal.repositorio.IUsuarioRepositorio;
import com.corenetworks.ProyectoFinal.servicio.IUsuarioServicio;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class IUsuarioServicioimpl extends ICRUDimpl <Usuario,Integer> implements IUsuarioServicio {
    @Autowired
    private IUsuarioRepositorio repositorio;
    @Autowired
    private ISeguidorRepositorio repositorioS;

    private ISeguidoRepositorio repositorioI;

    @Override
    protected IGeneralRepositorio<Usuario, Integer> getRepo() {
        return repositorio;
    }


    @Override
    public BuscarPorNombreDTO BuscarPorNombreUsuario(String nombreUsuario) {
        return repositorio.BuscarporNombreUsuario(nombreUsuario);
    }

}