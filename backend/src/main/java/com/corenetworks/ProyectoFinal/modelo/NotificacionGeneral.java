package com.corenetworks.ProyectoFinal.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "notificaciones")
public class NotificacionGeneral {
    private LocalDate fNotificacion;
    private String tipoNotificacion;


}
