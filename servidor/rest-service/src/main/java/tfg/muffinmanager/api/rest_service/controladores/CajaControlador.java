package tfg.muffinmanager.api.rest_service.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tfg.muffinmanager.api.rest_service.modelo.entidades.Caja;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.CajaServicio;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/caja")
public class CajaControlador {
    @Autowired
    CajaServicio cajaServicio;

    @GetMapping()
    public ArrayList<Caja> obtenerCajas() {
        return cajaServicio.obtenerCajas();
    }
    
    @PostMapping()
    public Caja guardarCaja(@RequestBody Caja caja) {
        return cajaServicio.guardarCaja(caja);
    }
    
    
}
