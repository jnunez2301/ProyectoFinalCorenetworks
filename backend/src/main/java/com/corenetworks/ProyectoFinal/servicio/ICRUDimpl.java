package com.corenetworks.ProyectoFinal.servicio;

import com.corenetworks.ProyectoFinal.repositorio.IGeneralRepositorio;

import java.util.List;

public abstract class ICRUDimpl <T,ID> implements  ICRUD<T,ID> {
    protected abstract IGeneralRepositorio<T,ID> getRepo();
    @Override
    public T buscarPorId(ID id) {
        return getRepo().findById(id).orElse(null);
    }

    @Override
    public List<T> buscarTodos() {
        return getRepo().findAll();
    }

    @Override
    public T crear(T t) {
        return getRepo().save(t);
    }

    @Override
    public T editar(T t) {
        return getRepo().save(t);
    }
}
