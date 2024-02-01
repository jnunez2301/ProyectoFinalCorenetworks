package com.corenetworks.ProyectoFinal.controlador;

import com.corenetworks.ProyectoFinal.exepcion.ExcepcionError;
import com.corenetworks.ProyectoFinal.modelo.Usuario;
import com.corenetworks.ProyectoFinal.servicio.IUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioControlador {
    @Autowired
    IUsuarioServicio usuarioServicio;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> mostrarUno(@PathVariable(name = "id") int id) {
        Usuario uccBB = usuarioServicio.buscarPorId(id);
        if (uccBB == null) {
            throw new ExcepcionError("Usuario no encontrado" + id);
        }
        return new ResponseEntity<>(uccBB, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> mostrarTodos() {
        return new ResponseEntity<>(usuarioServicio.buscarTodos(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Usuario> insertarUno(@RequestBody Usuario usr) {

        usr.setFCreacion(LocalDate.now());
        usr.setHCreacion(LocalTime.now());

        if(usr.getContrasena() == null || usr.getContrasena().isEmpty() || usr.getContrasena().length() < 8){
            System.out.println("La contraseña debe ser más larga que 8 caracteres");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Usuario uDB = usuarioServicio.crear(usr);

        return new ResponseEntity<>(uDB, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity <Usuario> modificarUno(@RequestBody Usuario u) {
        Usuario UccBB = usuarioServicio.buscarPorId(u.getIdUsuario());
        if (UccBB == null) {
            throw new ExcepcionError("Usuario no encontrado" + UccBB);
        }
        return new ResponseEntity<>(usuarioServicio.editar(u),HttpStatus.OK);
    }



}
