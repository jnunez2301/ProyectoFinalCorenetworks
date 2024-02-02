package com.corenetworks.ProyectoFinal.servicio;

import com.corenetworks.ProyectoFinal.modelo.Comentario;
import com.corenetworks.ProyectoFinal.repositorio.IComentarioRepositorio;
import com.corenetworks.ProyectoFinal.repositorio.IGeneralRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IComentarioServicioImpl extends ICRUDimpl <Comentario, Integer> {
    @Autowired
    private IComentarioRepositorio repositorio;
    @Override
    protected IGeneralRepositorio<Comentario, Integer> getRepo() {
        return repositorio;
    }
}
