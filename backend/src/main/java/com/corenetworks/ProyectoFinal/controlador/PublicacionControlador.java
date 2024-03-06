package com.corenetworks.ProyectoFinal.controlador;

import com.corenetworks.ProyectoFinal.exepcion.ExcepcionPersonalizada;

import com.corenetworks.ProyectoFinal.modelo.Publicacion;
import com.corenetworks.ProyectoFinal.modelo.Usuario;
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
@CrossOrigin(origins = "http://localhost:4200")
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
    public ResponseEntity<Publicacion> guardarPublicacion(@RequestBody Publicacion publicacion, @PathVariable int id_usuario) throws Exception {
        if(usuarioServicioimpl.buscarPorId(id_usuario) == null) {
            throw new ExcepcionPersonalizada("El usuario con el id: "+id_usuario+" no existe");
        }
        if(publicacion.getDescripcion().isEmpty() || publicacion.getDescripcion().length() < 10){
            throw new ExcepcionPersonalizada("La descripcion no puede estar vacia y debe ser mayor a 10 caracteres");
        }

        Usuario usuario = usuarioServicioimpl.buscarPorId(id_usuario);
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
