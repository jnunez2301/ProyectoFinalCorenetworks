
package com.corenetworks.ProyectoFinal.modelo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "perfil")
public class Perfil{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPerfil;
    private int numSeguidores;
    private int numSiguiendo;
    private int numPublicaciones;
    private String fotoPerfil;
    @Column(length = 250)
    private String descripcion;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_usuario", nullable = false, foreignKey = @ForeignKey(name = "FK_perfil_usuario"))
    private Usuario usuario;

}

