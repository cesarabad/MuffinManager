package tfg.muffinmanager.api.rest_service.servicios;

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
