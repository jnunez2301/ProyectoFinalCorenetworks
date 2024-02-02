package com.corenetworks.ProyectoFinal.repositorio;

import com.corenetworks.ProyectoFinal.modelo.Mensaje;
import com.corenetworks.ProyectoFinal.modelo.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMensajeRepositorio extends IGeneralRepositorio<Mensaje, Integer>{
 @Query(value = "Select m.contenido,u.nombre_usuario,m.f_creacion,m.h_creacion,m.id_mensaje,m.url_fotos,usuario_destino_id,usuario_origen_id from mensajes m\n" +
         "inner join usuarios u\n" +
         "on u.id_usuario = m.usuario_origen_id\n" +
         "where  m.usuario_origen_id =:id",nativeQuery = true)
 List<Mensaje> filtroMensajesPoridUsuario(@Value("id") int id);
}
