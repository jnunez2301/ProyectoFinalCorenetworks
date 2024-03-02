package com.corenetworks.ProyectoFinal.repositorio;

import com.corenetworks.ProyectoFinal.dto.CantidadSeguidoresDTO;
import com.corenetworks.ProyectoFinal.dto.SeguidorDTO;
import com.corenetworks.ProyectoFinal.modelo.Seguidor;
import com.corenetworks.ProyectoFinal.modelo.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISeguidorRepositorio extends IGeneralRepositorio<Seguidor,Long> {
    List<Seguidor> findBySeguido(Usuario seguido);

   @Query("SELECT NEW com.corenetworks.ProyectoFinal.dto.CantidadSeguidoresDTO(s.seguido.nombreUsuario, COUNT(s.seguidor)) " +
            "FROM Seguidor s " +
           "WHERE s.seguido.nombreUsuario = :nombreUsuarioSeguido " +
            "GROUP BY s.seguido.nombreUsuario")
    List<CantidadSeguidoresDTO> seguidor(@Param("nombreUsuarioSeguido") String nombreUsuario);


}
