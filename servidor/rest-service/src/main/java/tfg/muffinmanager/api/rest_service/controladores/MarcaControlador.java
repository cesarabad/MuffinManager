package tfg.muffinmanager.api.rest_service.controladores;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tfg.muffinmanager.api.rest_service.modelo.dto.MarcaDTO;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.MarcaServicio;


@RestController
@RequestMapping("/marca")
public class MarcaControlador {

    @Autowired
    MarcaServicio marcaServicio;

    @GetMapping()
    public ArrayList<MarcaDTO> obtenerMarcas() {
        return marcaServicio.obtenerMarcas();
    }

    
    
}
