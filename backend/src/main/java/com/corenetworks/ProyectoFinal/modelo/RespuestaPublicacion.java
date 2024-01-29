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
@Table(name = "respuestas")
public class RespuestaPublicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRespuesta;
    private int likes;
    private String mensajes;
    private LocalDate fCreacion;

    @ManyToOne
    @JoinColumn(name = "publicacion_id")
    private Publicaciones publicacion;
}