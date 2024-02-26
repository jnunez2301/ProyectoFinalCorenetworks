package com.corenetworks.ProyectoFinal.repositorio;

import com.corenetworks.ProyectoFinal.dto.MensajeDTO;
import com.corenetworks.ProyectoFinal.dto.UsuarioDTO;
import com.corenetworks.ProyectoFinal.modelo.Mensaje;
import com.corenetworks.ProyectoFinal.modelo.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Objects;

public interface IMensajeRepositorio extends IGeneralRepositorio<Mensaje, Integer>{
 @Query(value = "Select m.id_mensaje,m.contenido,m.f_creacion,m.h_creacion,m.url_fotos,u.nombre_usuario,d.nombre_usuario \n" +
         "from mensajes m \n" +
         "inner join usuarios u\n" +
         "on u.id_usuario= m.usuario_origen_id\n" +
         "inner join usuarios d\n" +
         "on d.id_usuario= m.usuario_destino_id\n" +
         "where usuario_origen_id=:id",nativeQuery = true)
 List<MensajeDTO> filtroMensajesPoridUsuario(@Value("id") int id) throws Exception;

 @Query(value="SELECT m.id_mensaje,m.contenido FROM mensajes m WHERE m.usuario_origen_id =:id  ORDER BY m.id_mensaje DESC LIMIT 5",nativeQuery = true)
 List<MensajeDTO> ultimos5mensajes(@Value("id") int id) throws Exception;
}
