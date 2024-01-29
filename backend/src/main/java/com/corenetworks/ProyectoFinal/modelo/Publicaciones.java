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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPublicacion;
    private String descripcion;
    private int cantidadLikes;
    private String contenido;
    private String urlCompartir;
    //private String guardar;
    private LocalDate fCreacion;

    /*
    * FK_usuarios_publicaciones
    * */
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false, foreignKey = @ForeignKey(name = "FK_usuario_publicacion")) // adjust the column name
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "id_comentario", nullable = false, foreignKey = @ForeignKey(name = "FK_comentario_publicacion"))
    private Comentario comentario;

}
