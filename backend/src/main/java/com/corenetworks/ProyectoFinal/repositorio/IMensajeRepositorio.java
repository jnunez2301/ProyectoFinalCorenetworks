package com.corenetworks.ProyectoFinal.repositorio;

import com.corenetworks.ProyectoFinal.modelo.Mensaje;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IMensajeRepositorio extends IGeneralRepositorio<Mensaje, Integer>{
 @Query(value = "Select m.id_mensaje,m.contenido,m.f_creacion,m.h_creacion,m.url_fotos,u.nombre_usuario,d.nombre_usuario \n" +
         "from mensajes m \n" +
         "inner join usuarios u\n" +
         "on u.id_usuario= m.usuario_origen_id\n" +
         "inner join usuarios d\n" +
         "on d.id_usuario= m.usuario_destino_id\n" +
         "where usuario_origen_id=:id",nativeQuery = true)
 List<Object[]> filtroMensajesPoridUsuario(@Value("id") int id) throws Exception;

}
