package tfg.muffinmanager.api.rest_service.controladores;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tfg.muffinmanager.api.rest_service.modelo.dto.StockProductoDTO;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.StockProductoServicio;

@RestController
@RequestMapping("producto_terminado/stock")
public class StockProductoControlador {

    @Autowired
    StockProductoServicio stockProductoServicio;

    @GetMapping()
    public ArrayList<StockProductoDTO> obtenerStockProductos() {
        return stockProductoServicio.obtenerStockProductos();
    }

    @PostMapping()
    public StockProductoDTO crearStockProducto(@RequestBody StockProductoDTO stockProductoDTO) {
        
        return stockProductoServicio.crearStockProducto(stockProductoDTO);
    }
}
