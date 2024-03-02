package com.corenetworks.ProyectoFinal.repositorio;

import com.corenetworks.ProyectoFinal.modelo.Seguidor;
import com.corenetworks.ProyectoFinal.modelo.Usuario;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISeguidorRepositorio extends IGeneralRepositorio<Seguidor, Long> {
    List<Seguidor> findBySeguido(Usuario seguido);
}
