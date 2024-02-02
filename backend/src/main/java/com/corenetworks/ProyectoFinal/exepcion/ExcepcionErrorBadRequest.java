package com.corenetworks.ProyectoFinal.exepcion;

public class ExcepcionErrorBadRequest extends RuntimeException{
    public ExcepcionErrorBadRequest(String message) {
        super(message);
    }
}
