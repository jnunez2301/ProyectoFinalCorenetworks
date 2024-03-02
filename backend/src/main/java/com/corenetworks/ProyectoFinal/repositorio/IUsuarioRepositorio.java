package com.corenetworks.ProyectoFinal.repositorio;

import com.corenetworks.ProyectoFinal.modelo.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUsuarioRepositorio extends IGeneralRepositorio<Usuario,Integer> {

}
