package com.corenetworks.ProyectoFinal.controlador;

import com.corenetworks.ProyectoFinal.dto.SeguidorDTO;
import com.corenetworks.ProyectoFinal.servicio.Impl.ISeguidorServicioImpl;
import com.corenetworks.ProyectoFinal.servicio.Impl.IUsuarioServicioimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seguidores")
public class SeguidorController {
    @Autowired
    ISeguidorServicioImpl seguidorServicio;
    @Autowired
    IUsuarioServicioimpl usuarioServicioimpl;
    @GetMapping("/usuario/{idUsuario}/seguidores")
    public ResponseEntity<List<SeguidorDTO>> obtenerSeguidores(@PathVariable int idUsuario) throws Exception {

        return ResponseEntity.ok(seguidorServicio.obtenerSeguidores(usuarioServicioimpl.buscarPorId(idUsuario)));
    }
    @PostMapping("/seguir/{idSeguidor}/{idSeguido}")
    public ResponseEntity<String> seguirUsuario(@PathVariable int idSeguidor, @PathVariable int idSeguido) {
        try {
            // Guarda el objeto Seguidor en la base de datos
            if(usuarioServicioimpl.buscarPorId(idSeguido) == null || usuarioServicioimpl.buscarPorId(idSeguidor) == null){
                return ResponseEntity.badRequest().body("No existe la id del seguido o la id del seguidor");
            }
            seguidorServicio.seguirUsuario(idSeguidor, idSeguido);
            return ResponseEntity.ok("Se ha seguido al usuario correctamente.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al intentar seguir al usuario: " + e.getMessage());
        }
    }

}
