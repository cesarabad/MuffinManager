package tfg.muffinmanager.api.rest_service.controladores;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tfg.muffinmanager.api.rest_service.modelo.dto.ArticuloDTO;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.ArticuloServicio;

@RestController
@RequestMapping("/articulo")
public class ArticuloControlador {

    @Autowired
    ArticuloServicio articuloServicio;

    @GetMapping()
    public ArrayList<ArticuloDTO> obtenerArticulos() {
        return articuloServicio.obtenerArticulos();
    }


    @PostMapping()
    public ArticuloDTO guardarArticulo(@RequestBody ArticuloDTO articulo) {
        return articuloServicio.guardarArticulo(articulo);
    }
}
