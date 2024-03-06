package com.corenetworks.ProyectoFinal.repositorio;

import com.corenetworks.ProyectoFinal.dto.PerfilDTO;
import com.corenetworks.ProyectoFinal.modelo.Perfil;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IPerfilRespositorio extends IGeneralRepositorio<Perfil,Long> {
    @Query(value = "SELECT NEW com.corenetworks.ProyectoFinal.dto.PerfilDTO(p.idPerfil, p.fotoPerfil, p.descripcion, p.usuario.nombreUsuario) FROM Perfil p JOIN p.usuario u WHERE u.nombreUsuario= :nombreUsuario")
  PerfilDTO DatosPerfil(@Param("nombreUsuario") String nombreUsuario);
}
