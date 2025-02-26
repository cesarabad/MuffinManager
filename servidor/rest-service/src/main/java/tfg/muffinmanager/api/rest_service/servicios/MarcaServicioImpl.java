package tfg.muffinmanager.api.rest_service.servicios;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfg.muffinmanager.api.rest_service.modelo.dto.MarcaDTO;
import tfg.muffinmanager.api.rest_service.modelo.entidades.Marca;
import tfg.muffinmanager.api.rest_service.repositorios.MarcaRepositorio;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.MarcaServicio;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.UsuarioServicio;

@Service
public class MarcaServicioImpl implements MarcaServicio{

    @Autowired
    MarcaRepositorio marcaRepositorio;
    @Autowired
    UsuarioServicio usuarioServicio;

    @Override
    public MarcaDTO guardarMarca(MarcaDTO marcaDTO) {
        return marcaRepositorio.save(dtoToMarca(marcaDTO)).toDTO();
    }

    public Marca dtoToMarca(MarcaDTO marcaDTO) {
        Marca marca = new Marca();
        marca = new Marca(marcaDTO.getId(), 
        marcaDTO.getNombre()
        ,marcaDTO.getLogo()
        ,marcaDTO.getVersion()
        ,Timestamp.valueOf(marcaDTO.getFechaCreacion())
        ,marcaDTO.getFechaFin() != null ? Timestamp.valueOf(marcaDTO.getFechaFin()) : null
        ,marcaDTO.isActivo()
        ,usuarioServicio.dtoToUsuario(marcaDTO.getResponsable()));
        return marca;
    }

    @Override
    public ArrayList<MarcaDTO> obtenerMarcas() {
        ArrayList<MarcaDTO> marcas = new ArrayList<>();
        marcaRepositorio.findAll().forEach(marca -> marcas.add(marca.toDTO()));
        return marcas;
    }

    @Override
    public Marca obtenerPorId(String id) {
        return marcaRepositorio.findByIdMarca(id);
    }

}
