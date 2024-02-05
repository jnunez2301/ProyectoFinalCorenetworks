package com.corenetworks.ProyectoFinal.servicio.Impl;

import com.corenetworks.ProyectoFinal.modelo.Mensaje;
import com.corenetworks.ProyectoFinal.repositorio.IGeneralRepositorio;
import com.corenetworks.ProyectoFinal.repositorio.IMensajeRepositorio;
import com.corenetworks.ProyectoFinal.servicio.IMensajeServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;

@Service
public class IMensajeServicioImpl extends ICRUDimpl <Mensaje, Integer> implements IMensajeServicio {
    @Autowired
    private IMensajeRepositorio repositorio;


    @Override
    protected IGeneralRepositorio<Mensaje,Integer> getRepo() {
        return repositorio;
    }

    @Override
    public List<Object[]> filtroMensajesporId(int id) throws Exception {
        return repositorio.filtroMensajesPoridUsuario(id);
    }

    @Override
    public List<Object[]> ultimos5mensajes(int id) throws Exception {
        return repositorio.ultimos5mensajes(id);
    }
}
