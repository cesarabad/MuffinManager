package tfg.muffinmanager.api.rest_service.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfg.muffinmanager.api.rest_service.repositorios.ArticuloRepositorio;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.ArticuloServicio;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.FormaServicio;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.MarcaServicio;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.UsuarioServicio;

@Service
public class ArticuloServicioImpl implements ArticuloServicio {

    @Autowired
    ArticuloRepositorio articuloRepositorio;
    @Autowired
    UsuarioServicio usuarioServicio;
    @Autowired
    FormaServicio formaServicio;
    @Autowired
    MarcaServicio marcaServicio;

    


}
