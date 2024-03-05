package com.corenetworks.ProyectoFinal.servicio.Impl;

import com.corenetworks.ProyectoFinal.dto.SeguidorDTO;
import com.corenetworks.ProyectoFinal.modelo.Seguidor;
import com.corenetworks.ProyectoFinal.modelo.Usuario;
import com.corenetworks.ProyectoFinal.repositorio.IGeneralRepositorio;
import com.corenetworks.ProyectoFinal.repositorio.ISeguidorRepositorio;
import com.corenetworks.ProyectoFinal.repositorio.IUsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ISeguidorServicioImpl extends ICRUDimpl<Seguidor, Long> {

    @Autowired
    private ISeguidorRepositorio seguidorRepositorio;
    @Autowired
    private IUsuarioRepositorio usuarioRepositorio;
    @Override
    protected IGeneralRepositorio<Seguidor, Long> getRepo() {
        return seguidorRepositorio;
    }

    public List<SeguidorDTO> obtenerSeguidores(Usuario seguido) {
        List<Seguidor> seguidores = seguidorRepositorio.findBySeguido(seguido);
        List<SeguidorDTO> seguidoresDTO = new ArrayList<>();

        for (Seguidor seguidor : seguidores) {
            SeguidorDTO seguidorDTO = new SeguidorDTO();
            // Mapea los datos del Seguidor a un SeguidorDTO
            seguidorDTO.setId(seguidor.getId());
            seguidorDTO.setNombreUsuarioSeguidor(seguidor.getSeguidor().getNombreUsuario());
            seguidorDTO.setNombreUsuarioSeguido(seguidor.getSeguido().getNombreUsuario());
            seguidoresDTO.add(seguidorDTO);
        }
        return seguidoresDTO;
    }

    public void seguirUsuario(int idSeguidor, int idSeguido) {
        Usuario seguidor = usuarioRepositorio.findById(idSeguidor).orElse(null);
        Usuario seguido = usuarioRepositorio.findById(idSeguido).orElse(null);

        Seguidor nuevoSeguidor = new Seguidor();
        nuevoSeguidor.setSeguidor(seguidor);
        nuevoSeguidor.setSeguido(seguido);
        seguidorRepositorio.save(nuevoSeguidor);
    }

}
