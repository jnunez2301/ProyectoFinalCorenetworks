package com.corenetworks.ProyectoFinal.modelo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "comentarios")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComentario;
    private int likes;
    private String mensajes;
    private String respuestasUsuarios;
    private LocalDate fCreacion;
    private LocalTime hCreacion;

    @ManyToOne
    @JoinColumn(name = "id_usuario",foreignKey = @ForeignKey(name = "FK_comentarios_usuarios"))
    private Usuario usuario;
}
