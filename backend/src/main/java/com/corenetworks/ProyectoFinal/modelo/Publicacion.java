package com.corenetworks.ProyectoFinal.modelo;

import java.time.LocalDate;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "publicaciones")
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPublicacion;
    private String descripcion;
    private int cantidadLikes;
    private String contenido; // ¿Imagen o video?
    private String urlCompartir;
    //private String guardar;
    private LocalDate fCreacion;
    private LocalTime hCreacion;

    public Publicacion(int idPublicacion, String descripcion, int cantidadLikes, String contenido, String urlCompartir, LocalDate fCreacion, LocalTime hCreacion, Usuario usuario) {
        this.idPublicacion = idPublicacion;
        this.descripcion = descripcion;
        this.cantidadLikes = cantidadLikes;
        this.contenido = contenido;
        this.urlCompartir = urlCompartir;
        this.fCreacion = fCreacion;
        this.hCreacion = hCreacion;
        this.usuario = usuario;
    }
    /*
    * FK_usuarios_publicaciones
    * */

    // Comentario
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false, foreignKey = @ForeignKey(name = "FK_usuario_publicacion")) // adjust the column name
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "id_comentario", foreignKey = @ForeignKey(name = "FK_comentario_publicacion"))
    private Comentario comentario;



}
