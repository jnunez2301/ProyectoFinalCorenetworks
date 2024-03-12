package com.corenetworks.ProyectoFinal.controlador;

import com.corenetworks.ProyectoFinal.dto.PerfilDTO;
import com.corenetworks.ProyectoFinal.dto.views;
import com.corenetworks.ProyectoFinal.servicio.IPerfilServicio;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/miPerfil")
@CrossOrigin(origins = "http://localhost:4200")
public class PerfilControlador {
    @Autowired
    IPerfilServicio servicio;
    @JsonView(views.Public.class)
    @GetMapping("/{nombreUsuario}")
    public ResponseEntity<PerfilDTO> datosPerfil(@PathVariable("nombreUsuario")String nombreUsuario) throws Exception{
        return new ResponseEntity<>(servicio.datosPerfil(nombreUsuario), HttpStatus.OK);
    }

}
