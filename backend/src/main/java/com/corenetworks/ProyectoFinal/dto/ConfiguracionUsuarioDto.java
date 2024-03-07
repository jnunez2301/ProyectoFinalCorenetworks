package com.corenetworks.ProyectoFinal.dto;

import com.corenetworks.ProyectoFinal.modelo.Mensaje;
import com.corenetworks.ProyectoFinal.modelo.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ConfiguracionUsuarioDto {

    private int idUsuario;
    private String nombreUsuario;
    private String contrasena;
    private String salt;
    private String correo;
    private String preguntaSecreta;


    public Usuario castUusuario(){
        Usuario u1= new Usuario();
        u1.setIdUsuario(idUsuario);
        u1.setNombreUsuario(nombreUsuario);
        u1.setContrasena(contrasena);
        u1.setSalt(salt);
        u1.setCorreo(correo);
        u1.setPreguntaSecreta(preguntaSecreta);
        return u1;
    }
    public  ConfiguracionUsuarioDto castUsuarioDTO(Usuario u){
        idUsuario = u.getIdUsuario();
        nombreUsuario= u.getNombreUsuario();
        contrasena = u.getContrasena();
        salt = u.getSalt();
        correo = u.getCorreo();
        preguntaSecreta = u.getPreguntaSecreta();
        return this;
    }

}
