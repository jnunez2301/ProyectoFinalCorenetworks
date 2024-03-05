package com.corenetworks.ProyectoFinal.dto;

import com.corenetworks.ProyectoFinal.modelo.Seguidor;
import com.corenetworks.ProyectoFinal.modelo.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
=======
<<<<<<< HEAD
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SeguidorDTO {
    private int id;
    private String NombreUsuarioSeguido;
    private String NombreUsuarioSeguidor;

=======
>>>>>>> main
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SeguidorDTO {
    private Long id;
    private String nombreUsuarioSeguido;
    private String nombreUsuarioSeguidor;
<<<<<<< HEAD
=======
>>>>>>> main
>>>>>>> main
    public Seguidor castSeguidor(){
        Seguidor s1 = new Seguidor();
        Usuario uSeguido = new Usuario();
        Usuario follower = new Usuario();


<<<<<<< HEAD
        uSeguido.setNombreUsuario(nombreUsuarioSeguido);

        follower.setNombreUsuario(nombreUsuarioSeguidor);
=======
<<<<<<< HEAD
        uSeguido.setNombreUsuario(NombreUsuarioSeguido);

        follower.setNombreUsuario(NombreUsuarioSeguidor);
=======
        uSeguido.setNombreUsuario(nombreUsuarioSeguido);

        follower.setNombreUsuario(nombreUsuarioSeguidor);
>>>>>>> main
>>>>>>> main

        s1.setSeguido(uSeguido);
        s1.setSeguidor(follower);

        return s1;
    }
}
