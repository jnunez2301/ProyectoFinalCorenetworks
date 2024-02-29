package com.corenetworks.ProyectoFinal.controlador;

import com.corenetworks.ProyectoFinal.dto.HistorialChatsDTO;
import com.corenetworks.ProyectoFinal.dto.MensajeDTO;
import com.corenetworks.ProyectoFinal.exepcion.ExcepcionPersonalizada;
import com.corenetworks.ProyectoFinal.modelo.Mensaje;
import com.corenetworks.ProyectoFinal.modelo.Usuario;
import com.corenetworks.ProyectoFinal.servicio.IMensajeServicio;
import com.corenetworks.ProyectoFinal.servicio.Impl.IUsuarioServicioimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/mensajes")
public class MensajeControlador {
    @Autowired
    IMensajeServicio mensajeServicio;
    @Autowired
    IUsuarioServicioimpl usuarioServicioimpl;

    @GetMapping
    public ResponseEntity <List<Mensaje>> mostrarTodos() throws Exception {
        return new ResponseEntity<>(mensajeServicio.buscarTodos(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<MensajeDTO>>buscarMensajesporId(@PathVariable(name = "id") int id) throws Exception {
        return new ResponseEntity<>(mensajeServicio.filtroMensajesporId(id),HttpStatus.OK);
    }

    @PostMapping("/enviarmensajes/{idO}/a/{idD}")
    public ResponseEntity<Mensaje> enviarMensaje(@PathVariable("idO") int idOrigen,@PathVariable("idD") int idDestino, @RequestBody Mensaje mensaje) throws Exception {
        Usuario usuarioDestino = usuarioServicioimpl.buscarPorId(idDestino);
        if (usuarioDestino == null) {
            throw new ExcepcionPersonalizada("El usuario con el id: " + idDestino + " no existe");
        }
        mensaje.setUsuarioDestino(usuarioDestino);
        Usuario usuarioOrigen = usuarioServicioimpl.buscarPorId(idOrigen);
        mensaje.setUsuarioOrigen(usuarioOrigen);
        mensaje.setFCreacion(LocalDate.now());
        mensaje.setHCreacion(LocalTime.now());
        Mensaje mensajeEnviado = mensajeServicio.enviarMensaje(mensaje);

        return new ResponseEntity<>(mensajeEnviado, HttpStatus.CREATED);
    }
    @GetMapping("/de/{id_origen}/con/{id_destino}")
    public ResponseEntity<List<HistorialChatsDTO>> historialChats(@PathVariable("id_origen")int id_origen,@PathVariable("id_destino")int id_destino) throws Exception {
       return new ResponseEntity<>(mensajeServicio.historialChats(id_origen,id_destino), HttpStatus.OK);

    }


    }

