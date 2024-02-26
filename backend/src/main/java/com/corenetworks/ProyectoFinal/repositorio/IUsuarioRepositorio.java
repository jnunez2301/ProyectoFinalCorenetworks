package com.corenetworks.ProyectoFinal.repositorio;

import com.corenetworks.ProyectoFinal.dto.UsuarioDTO;
import com.corenetworks.ProyectoFinal.modelo.Mensaje;
import com.corenetworks.ProyectoFinal.modelo.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUsuarioRepositorio extends IGeneralRepositorio<Usuario,Integer> {
    @Query(value="SELECT m.id_mensaje,m.contenido FROM mensajes m WHERE m.usuario_origen_id =:id  ORDER BY m.id_mensaje DESC LIMIT 5",nativeQuery = true)
    List<UsuarioDTO> ultimos5mensajes(@Value("id") int id) throws Exception;
}
