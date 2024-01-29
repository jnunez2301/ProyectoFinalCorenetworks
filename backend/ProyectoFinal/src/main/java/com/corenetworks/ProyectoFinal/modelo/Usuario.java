package com.corenetworks.ProyectoFinal.modelo;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    @Column(length = 30, nullable = false)
    private String contraseña;
    @Column(length = 60, nullable = false)
    private String correo;
    @Column(length = 60, nullable = false)
    private String preguntaSecreta;
    private String fotoPerfil;
    @Column(length = 30, nullable = false)
    private String nombreUsuario;
    @Column(length = 150)
    private String descripcion;
    private String publicaciones;
    private LocalDate fCreacion;
    private int numSeguidores;
    private int numSeguidos;
    private int numPublicaciones;
}
