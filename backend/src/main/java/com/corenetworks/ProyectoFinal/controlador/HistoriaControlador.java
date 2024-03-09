package com.corenetworks.ProyectoFinal.controlador;

import com.corenetworks.ProyectoFinal.dto.views;
import com.corenetworks.ProyectoFinal.modelo.Historia;
import com.corenetworks.ProyectoFinal.servicio.IHistoriaServicio;
import com.corenetworks.ProyectoFinal.servicio.ISeguidorServicio;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/historias")
public class HistoriaControlador {
    @Autowired
    IHistoriaServicio servicio;
    @Autowired

    ISeguidorServicio seServicio;

    /*
    TODO: Eliminar fecha final
    TODO: Añadir validaciones a las peticiones
    *   */

    @JsonView(views.Public.class)
    @PostMapping("/publicas")
    public ResponseEntity<Historia> subirHistoriaPublica(@PathVariable("usuario") int usuario, @RequestBody Historia h) throws Exception {
        h.setActivo(true);
        h.setHCreacion(LocalTime.now());
        h.setFCreacion(LocalDate.now());
        h.getUsuario().setIdUsuario(usuario);
        h.setPublicas(true);
        return new ResponseEntity<>(servicio.crear(h), HttpStatus.CREATED);
    }
    @JsonView(views.Public.class)
    @PostMapping("/privadas")
    public ResponseEntity<Historia> subirHistoriaPrivada(@PathVariable("usuario") int usuario, @RequestBody Historia h) throws Exception {
        h.setActivo(true);
        h.setHCreacion(LocalTime.now());
        h.setFCreacion(LocalDate.now());
        h.getUsuario().setIdUsuario(usuario);
        h.setPublicas(false);
        return new ResponseEntity<>(servicio.crear(h), HttpStatus.CREATED);
    }

    //Mañana hacer que el ver en publicas o privadas

    @JsonView(views.Public.class)
    @GetMapping("/de/{idPropietario}/closefriends/{idSeguidor}")
    public ResponseEntity<List<Historia>> HistoriaVisiblePorSeguidor(@PathVariable("idPropietario") int idPropietario, @PathVariable("idSeguidor") int idSeguidor) throws Exception {
        try {
            if (seServicio.isSeguidor(idSeguidor, idPropietario) == false) {
                throw new Exception("No tienes acceso");
            }
            List<Historia> historiavisible = servicio.HistoriasVisiblesPorSeguidor(idPropietario);
            return new ResponseEntity<>(historiavisible, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }
    @JsonView(views.Public.class)
    @GetMapping("/de/{idPropietario}")
    public ResponseEntity<List<Historia>> HistoriaPatodos(@PathVariable("idPropietario") int idPropietario){
        return new ResponseEntity<>(servicio.HistoriasPaTodos(idPropietario),HttpStatus.OK);
    }
}



