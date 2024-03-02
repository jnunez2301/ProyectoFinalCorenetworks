package com.corenetworks.ProyectoFinal.dto;

import com.corenetworks.ProyectoFinal.modelo.Seguidor;
import com.corenetworks.ProyectoFinal.modelo.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SeguidorDTO {
    private Long id;
    private String nombreUsuarioSeguido;
    private String nombreUsuarioSeguidor;
    public Seguidor castSeguidor(){
        Seguidor s1 = new Seguidor();
        Usuario uSeguido = new Usuario();
        Usuario follower = new Usuario();


        uSeguido.setNombreUsuario(nombreUsuarioSeguido);

        follower.setNombreUsuario(nombreUsuarioSeguidor);

        s1.setSeguido(uSeguido);
        s1.setSeguidor(follower);

        return s1;
    }
}
