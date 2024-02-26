package com.corenetworks.ProyectoFinal.dto;

import com.corenetworks.ProyectoFinal.modelo.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioDTO {
    private int idUsuario;
    private String nombreUsuario;
    public Usuario castUsuario(){
        Usuario u1= new Usuario();
        u1.setIdUsuario(idUsuario);
        u1.setNombreUsuario(nombreUsuario);
        return u1;
    }
    public  UsuarioDTO castUsuarioDTO(Usuario u){
        idUsuario=u.getIdUsuario();
        nombreUsuario=u.getNombreUsuario();
        return this;
    }
}
