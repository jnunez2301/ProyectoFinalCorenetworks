package com.corenetworks.ProyectoFinal.modelo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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
    private LocalDate fCreacion;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false, foreignKey = @ForeignKey(name = "FK_historias_usuario"))
    private Usuario usuario;
    // Usuarios Autorizados
    /*private List<Usuario> listaAutorizados;*/
    // Usuarios que no deben ver las historias
    /*private List<Usuario> listaExcluidos;*/
    
}
