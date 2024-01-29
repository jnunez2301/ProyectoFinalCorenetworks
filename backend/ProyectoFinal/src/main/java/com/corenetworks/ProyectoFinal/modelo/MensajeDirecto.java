package com.corenetworks.ProyectoFinal.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "mensajes_directos")
public class MensajeDirecto {
    private LocalDate fCreacion;
    private String usuarioDestino;
    private String historialMensajes;
    private String fotos;
    private int likeComentarios;

}
