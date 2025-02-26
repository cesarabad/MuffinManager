package tfg.muffinmanager.api.rest_service.controladores;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tfg.muffinmanager.api.rest_service.modelo.dto.FormaDTO;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.FormaServicio;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/forma")
public class FormaControlador {
 
    @Autowired
    FormaServicio formaServicio;

    @GetMapping()
    public ArrayList<FormaDTO> obtenerFormas() {
        return formaServicio.obtenerFormas();
    }

    @PostMapping()
    public FormaDTO guardarForma(@RequestBody FormaDTO forma) {
        return formaServicio.guardarForma(forma);
    }
    
}
