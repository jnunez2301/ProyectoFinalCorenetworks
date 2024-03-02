package com.corenetworks.ProyectoFinal.modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @JsonIgnore
    @Column(length = 120, nullable = false)
    private String contrasena;
    private String salt;

    @Column(length = 255, nullable = false, unique = true)
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


    @ManyToMany(mappedBy = "seguidores")
    @JsonBackReference
    @JsonIgnore
    private List<Usuario> seguidos;


    @ManyToMany
    @JsonBackReference
    @JoinTable(name = "seguidores",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "seguidor_id"))
    private List<Usuario> seguidores;
}
