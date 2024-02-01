package com.corenetworks.ProyectoFinal.modelo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "informacion_usuario")
public class InformacionUsuario {
    private int numSeguidores;
    private int numSiguiendo;
    private int numPublicaciones;
    private String fotoPerfil;
    @Column(length = 250)
    private String descripcion;

    @OneToOne
    @JoinColumn(name="id_usuario", nullable = false, foreignKey = @ForeignKey(name = "FK_informacion_usuario_usuario"))
    private Usuario usuario;
}
