package com.corenetworks.ProyectoFinal.controlador;

import com.corenetworks.ProyectoFinal.modelo.Comentario;
import com.corenetworks.ProyectoFinal.modelo.Publicacion;
import com.corenetworks.ProyectoFinal.modelo.Usuario;
import com.corenetworks.ProyectoFinal.servicio.IComentarioServicio;
import com.corenetworks.ProyectoFinal.servicio.IPublicacionServicio;
import com.corenetworks.ProyectoFinal.servicio.Impl.IUsuarioServicioimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/publicaciones")
public class PublicacionControlador {
    @Autowired
    IPublicacionServicio publicacionServicio;
    @Autowired
    IUsuarioServicioimpl usuarioServicioimpl;
    @GetMapping
    public ResponseEntity <List<Publicacion>> obtenerTodasPublicaciones() throws Exception {
        return new ResponseEntity<>(publicacionServicio.buscarTodos(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Publicacion> obtenerPublicaconId(@PathVariable int id) throws Exception {
        return new ResponseEntity<>(publicacionServicio.buscarPorId(id),HttpStatus.OK);
    }
    @PostMapping("/{id_usuario}")
    public ResponseEntity<Publicacion> guardarPublicacion(@RequestBody Publicacion publicacion, @PathVariable int id) throws Exception {
        Usuario usuario = usuarioServicioimpl.buscarPorId(id);
        publicacion.setUsuario(usuario);

        publicacion.setUrlCompartir("http://localhost:3000/api/publicaciones/"+publicacion.getIdPublicacion());

        publicacion.setFCreacion(LocalDate.now());
        publicacion.setHCreacion(LocalTime.now());
        publicacion.setCantidadLikes(0);

        return new ResponseEntity<>(publicacionServicio.crear(publicacion),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Publicacion> actualizarPublicacion(@RequestBody Publicacion publicacion) throws Exception {
        return new ResponseEntity<>(publicacionServicio.editar(publicacion),HttpStatus.OK);
    }
}
