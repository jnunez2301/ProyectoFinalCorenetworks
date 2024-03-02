package com.corenetworks.ProyectoFinal.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "seguidos")
public class Seguido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario_seguido")
    private Usuario seguido;

    @ManyToOne
    @JoinColumn(name = "id_usuario_seguidor")
    private Usuario seguidor;


}
