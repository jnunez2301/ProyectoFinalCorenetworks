package com.corenetworks.ProyectoFinal.dto;

import com.corenetworks.ProyectoFinal.modelo.Seguidor;
import com.corenetworks.ProyectoFinal.modelo.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SeguidorDTO {
    private Long id;
    private String nombreUsuarioSeguido;
    private int idUsuarioSeguido;
    private String nombreUsuarioSeguidor;
    private int idUsuarioSeguidor;

    public Seguidor castSeguidor(){
        Seguidor s1 = new Seguidor();
        Usuario uSeguido = new Usuario();
        Usuario uSeguidor = new Usuario();

        uSeguido.setIdUsuario(idUsuarioSeguido);
        uSeguido.setNombreUsuario(nombreUsuarioSeguido);

        uSeguidor.setIdUsuario(idUsuarioSeguidor);
        uSeguidor.setNombreUsuario(nombreUsuarioSeguidor);

        s1.setSeguido(uSeguido);
        s1.setSeguidor(uSeguidor);

        return s1;
    }
}
