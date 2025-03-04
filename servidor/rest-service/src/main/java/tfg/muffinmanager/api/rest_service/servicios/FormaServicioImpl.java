package tfg.muffinmanager.api.rest_service.servicios;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfg.muffinmanager.api.rest_service.modelo.dto.FormaDTO;
import tfg.muffinmanager.api.rest_service.modelo.entidades.Forma;
import tfg.muffinmanager.api.rest_service.repositorios.FormaRepositorio;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.FormaServicio;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.UsuarioServicio;

@Service
public class FormaServicioImpl implements FormaServicio {
    @Autowired
    FormaRepositorio formaRepositorio;

    @Autowired
    UsuarioServicio usuarioServicio;

    @Override
    public FormaDTO guardarForma(FormaDTO formaDTO) {
        return formaRepositorio.save(new Forma(formaDTO.getId()
        ,formaDTO.getDescripcion()
        ,formaDTO.getVersion()
        ,Timestamp.valueOf(formaDTO.getFechaCreacion())
        ,formaDTO.getFechaFin() != null ? Timestamp.valueOf(formaDTO.getFechaFin()) : null, formaDTO.isActivo(),
        usuarioServicio.obtenerEntidadPorDni(formaDTO.getResponsable()))).toDto();
        
    }

    @Override
    public ArrayList<FormaDTO> obtenerFormas() {
        ArrayList<FormaDTO> formas = new ArrayList<>();
        formaRepositorio.findAll().forEach(forma -> formas.add(forma.toDto()));
        return formas;
    }

    @Override
    public Forma obtenerPorId(String id) {
        return formaRepositorio.findByIdForma(id);
    }


}
