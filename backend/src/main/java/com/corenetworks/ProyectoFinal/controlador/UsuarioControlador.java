package com.corenetworks.ProyectoFinal.controlador;

import com.corenetworks.ProyectoFinal.modelo.Usuario;
import com.corenetworks.ProyectoFinal.servicio.IUsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioControlador {
    @Autowired
    IUsuarioServicio usuarioServicio;
    @GetMapping("/{id}")
    public Usuario mostrarUno(@PathVariable(name = "id") int id){
        return usuarioServicio.mostrarUno(id);
    }
    @GetMapping
    public List <Usuario> mostrarTodos(){
        return usuarioServicio.mostrarTodos();
    }
    @PostMapping
    public ResponseEntity <Usuario> insertarUno(@RequestBody Usuario u){
        Usuario CB= usuarioServicio.insertarUno(u);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping
    public Usuario modificarUno(@RequestBody Usuario u){
        return usuarioServicio.modificarUno(u);
    }



}
