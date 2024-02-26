package com.corenetworks.ProyectoFinal.controlador;

import com.corenetworks.ProyectoFinal.dto.MensajeDTO;
import com.corenetworks.ProyectoFinal.dto.UsuarioDTO;
import com.corenetworks.ProyectoFinal.modelo.Mensaje;
import com.corenetworks.ProyectoFinal.modelo.Usuario;
import com.corenetworks.ProyectoFinal.servicio.IMensajeServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/mensajes")
public class MensajeControlador {
    @Autowired
    IMensajeServicio mensajeServicio;

    @GetMapping
    public ResponseEntity <List<Mensaje>> mostrarTodos() throws Exception {
        return new ResponseEntity<>(mensajeServicio.buscarTodos(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<MensajeDTO>>buscarMensajesporId(@PathVariable(name = "id") int id) throws Exception {
        return new ResponseEntity<>(mensajeServicio.filtroMensajesporId(id),HttpStatus.OK);
    }

    @GetMapping("/ultimos5porid/{id}")
    public ResponseEntity<List<MensajeDTO>> ultimos5mensajesporId(@PathVariable(name = "id")int id) throws Exception{
        return new ResponseEntity<>(mensajeServicio.ultimos5mensajes(id),HttpStatus.OK);
    }
}
