package com.corenetworks.ProyectoFinal.servicio;

import com.corenetworks.ProyectoFinal.modelo.Mensaje;
import com.corenetworks.ProyectoFinal.modelo.Usuario;
import com.corenetworks.ProyectoFinal.repositorio.IGeneralRepositorio;
import com.corenetworks.ProyectoFinal.repositorio.IMensajeRepositorio;
import com.corenetworks.ProyectoFinal.repositorio.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

public class IMensajeServicioImpl extends ICRUDimpl <Mensaje, Integer> implements IMensajeServicio {
    @Autowired
    private IMensajeRepositorio repositorio;


    @Override
    protected IGeneralRepositorio<Mensaje,Integer> getRepo() {
        return repositorio;
    }

    @Override
    public List<Mensaje> filtroMensajesporId(int id) {
        return repositorio.filtroMensajesPoridUsuario(id);
    }
}
