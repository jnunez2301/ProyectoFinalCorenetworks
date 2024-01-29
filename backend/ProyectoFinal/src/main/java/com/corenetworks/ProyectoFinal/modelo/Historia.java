package com.corenetworks.ProyectoFinal.modelo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "historias")
public class Historia {
    private String contenido;
    //private String privadas;
    //private String publicas;
    //private String usuarioAutorizado;
    private LocalDate fCreacion;
    
}
