package com.corenetworks.ProyectoFinal.modelo;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "publicaciones")
public class Publicaciones {
    private String descripcion;
    private int cantidadLikes;
    private String contenido;
    private String urlCompartir;
    //private String guardar;
    private LocalDate fCreacion;

}
