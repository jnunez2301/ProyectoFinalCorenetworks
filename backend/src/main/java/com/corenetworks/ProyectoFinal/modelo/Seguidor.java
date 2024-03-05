package com.corenetworks.ProyectoFinal.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
@NoArgsConstructor
@AllArgsConstructor
=======
<<<<<<< HEAD
@AllArgsConstructor
@NoArgsConstructor
=======
@NoArgsConstructor
@AllArgsConstructor
>>>>>>> main
>>>>>>> main
@Data
@Entity
@Table(name = "seguidores")
public class Seguidor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
<<<<<<< HEAD
=======
<<<<<<< HEAD
    @JoinColumn(name = "id_usuario_seguidor")
    private Usuario seguidor;

    @ManyToOne
    @JoinColumn(name = "id_usuario_seguido")
    private Usuario seguido;
=======
>>>>>>> main
    @JoinColumn(name = "seguidor_id", referencedColumnName = "idUsuario")
    private Usuario seguidor;

    @ManyToOne
    @JoinColumn(name = "seguido_id", referencedColumnName = "idUsuario")
    private Usuario seguido;

    public Seguidor(Usuario seguidor, Usuario seguido) {
        this.seguidor = seguidor;
        this.seguido = seguido;
    }
<<<<<<< HEAD
=======
>>>>>>> main
>>>>>>> main
}
