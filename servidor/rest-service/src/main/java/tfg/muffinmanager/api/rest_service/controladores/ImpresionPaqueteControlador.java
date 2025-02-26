package tfg.muffinmanager.api.rest_service.controladores;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tfg.muffinmanager.api.rest_service.modelo.entidades.ImpresionPaquete;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.ImpresionPaqueteServicio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/producto_terminado/impresion_paquete")
public class ImpresionPaqueteControlador {
    
    @Autowired
    ImpresionPaqueteServicio impresionPaqueteServicio;

    @GetMapping()
    public ArrayList<ImpresionPaquete> obtenerImpresionesPaquete() {
        return impresionPaqueteServicio.obtenerImpresionesPaquete();
    }

    @PostMapping()
    public ImpresionPaquete guardarImpresionPaquete(@RequestBody ImpresionPaquete impresionPaquete) {
        return impresionPaqueteServicio.guardarImpresionPaquete(impresionPaquete);
    }
    
}
