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
@Table(name = "mensajes_directos")
public class MensajeDirecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMensajeDirecto;

   /*
   * FK_mensajes_mensajes_directos
   * */
  
}

