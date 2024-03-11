package com.corenetworks.ProyectoFinal.dto;

public class views {
    public static class Public {} // Vista pública
    public static class Private extends Public {} // Vista privada

    public static class Comentarios extends Public {} // Para evitar bucle en comentarios
}
