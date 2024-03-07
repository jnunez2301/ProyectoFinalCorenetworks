package com.corenetworks.ProyectoFinal.modelo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "historias")
public class Historia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHistoria;
    private String contenido;
    private Boolean publicas;
    private Boolean Activo;
    private LocalDate fCreacion;
    private LocalTime hCreacion;
    private LocalDate fFinal;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false, foreignKey = @ForeignKey(name = "FK_historias_usuario"))
    private Usuario usuario;

//    private List<Usuario> listaAutorizados;
//
//    private List<Usuario> listaExcluidos;
//
}
