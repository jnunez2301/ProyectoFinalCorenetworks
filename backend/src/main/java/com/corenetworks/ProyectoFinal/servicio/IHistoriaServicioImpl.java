package com.corenetworks.ProyectoFinal.servicio;

import com.corenetworks.ProyectoFinal.modelo.Historia;
import com.corenetworks.ProyectoFinal.modelo.Mensaje;
import com.corenetworks.ProyectoFinal.repositorio.IGeneralRepositorio;
import com.corenetworks.ProyectoFinal.repositorio.IHistoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

public class IHistoriaServicioImpl extends ICRUDimpl <Historia, Integer> implements IHistoriaServicio{
    @Autowired
    private IHistoriaRepositorio repositorio;
    @Override
    protected IGeneralRepositorio<Historia, Integer> getRepo() {
        return repositorio;
    }
}
