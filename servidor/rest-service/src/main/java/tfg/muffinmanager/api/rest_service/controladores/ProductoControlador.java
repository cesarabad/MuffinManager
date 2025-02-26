package tfg.muffinmanager.api.rest_service.controladores;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tfg.muffinmanager.api.rest_service.modelo.dto.ProductoDTO;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.ProductoServicio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/producto")
public class ProductoControlador {
    @Autowired
    ProductoServicio productoServicio;

    @GetMapping()
    public ArrayList<ProductoDTO> obtenerProductos() {
        return productoServicio.obtenerProductos();
    }

    @PostMapping ()
    public ProductoDTO guardarProducto(@RequestBody ProductoDTO producto) {
        return productoServicio.guardarProducto(producto);
    }
    
    
}
