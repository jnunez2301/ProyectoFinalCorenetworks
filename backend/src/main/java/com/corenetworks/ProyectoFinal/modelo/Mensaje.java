package com.corenetworks.ProyectoFinal.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "mensajes")
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMensaje;
    private LocalDate fCreacion;
    @Column(nullable = false)
    private String contenido;
    private String urlFotos;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuarioOrigen_id", nullable = false)
    private Usuario usuarioOrigen;

    @ManyToOne(optional = false)
    @JoinColumn(name = "usuarioDestino_id", nullable = false)
    private Usuario usuarioDestino;
}
