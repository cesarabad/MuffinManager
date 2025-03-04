package tfg.muffinmanager.api.rest_service.servicios;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfg.muffinmanager.api.rest_service.modelo.dto.FormaDTO;
import tfg.muffinmanager.api.rest_service.modelo.entidades.Forma;
import tfg.muffinmanager.api.rest_service.modelo.entidades.ids.FormaId;
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
        Forma forma = new Forma(formaDTO.getId(), formaDTO.getDescripcion(), formaDTO.getVersion(),
                Timestamp.valueOf(formaDTO.getFechaCreacion()), formaDTO.getFechaFin() != null ? Timestamp.valueOf(formaDTO.getFechaFin()) : null,
                formaDTO.isActivo(), usuarioServicio.obtenerEntidadPorDni(formaDTO.getResponsable().getDni()));
        if (formaDTO.isActivo()) {
            ArrayList<Forma> formasId = formaRepositorio.findByIdForma(formaDTO.getId());
            for (Forma formaVersion : formasId) {
                if (formaVersion.isActivo()) {
                    formaVersion.setActivo(false);
                    formaRepositorio.save(formaVersion);
                }
            }
           
        }
        return formaRepositorio.save(forma).toDto();
    }

    @Override
    public ArrayList<FormaDTO> obtenerFormasActivas() {
        ArrayList<FormaDTO> formas = new ArrayList<>();
        formaRepositorio.findAll().forEach(forma -> {
            if (forma.isActivo()) {
                formas.add(forma.toDto());
            }
        });
        return formas;
    }

    @Override
    public ArrayList<FormaDTO> obtenerVersionesPorId(String id) {
        ArrayList<FormaDTO> formas = new ArrayList<>();
        formaRepositorio.findByIdForma(id).forEach(forma -> formas.add(forma.toDto()));
        return formas;
    }

    @Override
    public FormaDTO actualizarForma(FormaDTO formaDTO) {
        
        for (Forma formaVersion : formaRepositorio.findByIdForma(formaDTO.getId())) {
            if (formaVersion.isActivo()) {
                formaVersion.setActivo(false);
                formaVersion.setFechaFin(Timestamp.from(Instant.now()));
                formaRepositorio.save(formaVersion);
            }
        }
        Forma forma = new Forma(formaDTO.getId(), formaDTO.getDescripcion(), formaDTO.getVersion(),
                Timestamp.valueOf(formaDTO.getFechaCreacion()), formaDTO.getFechaFin() != null ? Timestamp.valueOf(formaDTO.getFechaFin()) : null,
                formaDTO.isActivo(), usuarioServicio.obtenerEntidadPorDni(formaDTO.getResponsable().getDni()));
        
        
        return formaRepositorio.save(forma).toDto();
    }

    @Override
    public boolean existeForma(String id) {
        return formaRepositorio.existsByIdForma(id);
    }

    @Override
    public boolean eliminarForma(String id) {
        for (Forma formaVersion : formaRepositorio.findByIdForma(id)) {
                formaRepositorio.delete(formaVersion);
        }
        return !existeForma(id);
    }

    @Override
    public boolean activarDesactivarForma(String id, int version) {
        
        Forma forma = formaRepositorio.findById(new FormaId(id, version)).get();
        forma.setActivo(!forma.isActivo());
        if (forma.isActivo()) {
            forma.setFechaFin(null);
        } else {
            forma.setFechaFin(Timestamp.from(Instant.now()));
        }
        forma.setFechaCreacion(Timestamp.from(Instant.now()));
        return formaRepositorio.save(forma) != null;
    }

    


}
