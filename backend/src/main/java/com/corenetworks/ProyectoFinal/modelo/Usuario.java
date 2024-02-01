package com.corenetworks.ProyectoFinal.modelo;

import java.time.LocalDate;
import java.time.LocalTime;

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

    @Column(length = 16, nullable = false, unique = true)
    private String nombreUsuario;

    @Column(length = 120, nullable = false)
    private String contrasena;
    private String salt;

    @Column(length = 255, nullable = false)
    private String correo;

    @Column(length = 60, nullable = false)
    private String preguntaSecreta;

    private LocalDate fCreacion;
    private LocalTime hCreacion;

    public Usuario(String nombreUsuario, String contrasena, String correo, String preguntaSecreta) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.correo = correo;
        this.preguntaSecreta = preguntaSecreta;
    }
}
