package com.corenetworks.ProyectoFinal.controlador;

import com.corenetworks.ProyectoFinal.modelo.Historia;
import com.corenetworks.ProyectoFinal.servicio.IHistoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@RequestMapping("/api/historias")
public class HistoriaControlador {
    @Autowired
  IHistoriaServicio servicio;

    /*
    TODO: Eliminar fecha final
    TODO: Añadir validaciones a las peticiones
    *   */
    @PostMapping("/publicas")
    public ResponseEntity <Historia> subirHistoriaPublica(@PathVariable("usuario") int usuario,@RequestBody Historia h) throws Exception {
            h.setActivo(true);
            h.setHCreacion(LocalTime.now());
            h.setFCreacion(LocalDate.now());
            h.getUsuario().setIdUsuario(usuario);
            h.setPublicas(true);
        return new ResponseEntity<>(servicio.crear(h), HttpStatus.CREATED);
    }

    @PostMapping("/privadas")
    public ResponseEntity <Historia> subirHistoriaPrivada(@PathVariable("usuario") int usuario,@RequestBody Historia h) throws Exception {
        h.setActivo(true);
        h.setHCreacion(LocalTime.now());
        h.setFCreacion(LocalDate.now());
        h.getUsuario().setIdUsuario(usuario);
        h.setPublicas(false);
        return new ResponseEntity<>(servicio.crear(h), HttpStatus.CREATED);
    }

    //Mañana hacer que el ver en publicas o privadas
    
}
