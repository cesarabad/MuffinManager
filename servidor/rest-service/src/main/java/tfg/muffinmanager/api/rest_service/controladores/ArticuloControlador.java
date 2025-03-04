package tfg.muffinmanager.api.rest_service.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tfg.muffinmanager.api.rest_service.servicios.interfaces.ArticuloServicio;

@RestController
@RequestMapping("/articulo")
public class ArticuloControlador {

    @Autowired
    ArticuloServicio articuloServicio;

    
}
