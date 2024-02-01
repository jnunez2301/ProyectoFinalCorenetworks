package com.corenetworks.ProyectoFinal.repositorio;

import com.corenetworks.ProyectoFinal.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepositorio extends IGeneralRepositorio<Usuario,Integer> {
}
