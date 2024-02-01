package com.corenetworks.ProyectoFinal.servicio;

import java.util.List;

public interface ICRUD <T,ID> {
    T buscarPorId(ID id);
    List<T> buscarTodos();
    T crear (T t);
    T editar (T t);
}
