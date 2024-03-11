package com.corenetworks.ProyectoFinal.modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import com.corenetworks.ProyectoFinal.dto.views;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "usuarios")
public class Usuario{
    @JsonView(views.Public.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    @JsonView(views.Public.class)
    @Column(length = 16, nullable = false, unique = true)
    private String nombreUsuario;

    @JsonView(views.Private.class)
    @Column(length = 120, nullable = false)
    private String contrasena;

    @JsonView(views.Private.class)
    private String salt;
    @JsonView(views.Private.class)
    @Column(length = 255, nullable = false, unique = true)
    private String correo;
    @JsonView(views.Private.class)
    @Column(length = 60, nullable = false)
    private String preguntaSecreta;
    @JsonView(views.Private.class)
    private LocalDate fCreacion;
    @JsonView(views.Private.class)
    private LocalTime hCreacion;
    // TODO: AÑADIR FOTO DE PERFIL

    public Usuario(String nombreUsuario, String contrasena, String correo, String preguntaSecreta) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.correo = correo;
        this.preguntaSecreta = preguntaSecreta;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "seguido")
    private List<Seguidor> seguidos;
    @JsonIgnore
    @OneToMany(mappedBy = "seguidor")
    private List<Seguidor> seguidores;



}
