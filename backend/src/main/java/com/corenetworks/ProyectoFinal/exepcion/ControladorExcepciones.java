package com.corenetworks.ProyectoFinal.exepcion;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestController
@ControllerAdvice
public class ControladorExcepciones extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ExcepcionErrorNotFound.class)
    public ResponseEntity<ExcepcionDetalles> GET(ExcepcionErrorNotFound ed, WebRequest peticion){
        ExcepcionDetalles e= new ExcepcionDetalles(LocalDateTime.now(),ed.getMessage(), peticion.getDescription(false));
        return new ResponseEntity<>(e, HttpStatus.NOT_FOUND);
    }

   @ExceptionHandler(ExcepcionErrorInternalServerError.class)
    public ResponseEntity<ExcepcionDetalles> post400(ExcepcionErrorNotFound ed, WebRequest peticion){
        ExcepcionDetalles e= new ExcepcionDetalles(LocalDateTime.now(),ed.getMessage(), peticion.getDescription(false));
        return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(ExcepcionErrorBadRequest.class)
    public ResponseEntity<ExcepcionDetalles> badRequest500(ExcepcionErrorBadRequest ee, WebRequest peticion){
    ExcepcionDetalles e= new ExcepcionDetalles(LocalDateTime.now(),ee.getMessage(), peticion.getDescription(false));
        return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
    }




}
