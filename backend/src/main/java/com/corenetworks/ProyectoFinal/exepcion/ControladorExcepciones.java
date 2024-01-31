package com.corenetworks.ProyectoFinal.exepcion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@RestController
@ControllerAdvice
public class ControladorExcepciones extends ResponseEntityExceptionHandler {
    public ResponseEntity<ExcepcionDetalles> buscadorErrores(ExcepcionDetalles ed, WebRequest peticion){
        ExcepcionDetalles e= new ExcepcionDetalles(ed.getFecha(), ed.getMensaje(), peticion.getDescription(false));
        return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
    }
}
