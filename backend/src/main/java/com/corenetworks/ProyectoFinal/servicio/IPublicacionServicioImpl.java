package com.corenetworks.ProyectoFinal.servicio;

import com.corenetworks.ProyectoFinal.modelo.Publicaciones;
import com.corenetworks.ProyectoFinal.modelo.Usuario;
import com.corenetworks.ProyectoFinal.repositorio.IGeneralRepositorio;
import com.corenetworks.ProyectoFinal.repositorio.IPublicacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

public class IPublicacionServicioImpl extends ICRUDimpl <Publicaciones,Integer> implements IPublicacionServicio{
    @Autowired
    private IPublicacionRepositorio repositorio;
    @Override

    protected IGeneralRepositorio<Publicaciones, Integer> getRepo() {
        return repositorio ;
    }
}
