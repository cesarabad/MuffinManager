package tfg.muffinmanager.api.rest_service.controladores;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tfg.muffinmanager.api.rest_service.modelo.dto.MovimientoStockDTO;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.MovimientoStockServicio;

@RestController
@RequestMapping("/producto_terminado/stock/movimiento")
public class MovimientoStockControlador {
    @Autowired
    MovimientoStockServicio movimientoStockServicio;

    @GetMapping()
    public ArrayList<MovimientoStockDTO> obtenerMovimientosStock() {
        return movimientoStockServicio.obtenerMovimientosStock();
    }

    @PostMapping()
    public MovimientoStockDTO guardarMovimientoStock(@RequestBody MovimientoStockDTO movimientoStockDTO) {
        return movimientoStockServicio.guardarMovimientoStock(movimientoStockDTO);
    }
}
