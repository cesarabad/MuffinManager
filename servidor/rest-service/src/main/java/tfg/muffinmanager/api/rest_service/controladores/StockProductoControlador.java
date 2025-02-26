package tfg.muffinmanager.api.rest_service.controladores;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tfg.muffinmanager.api.rest_service.modelo.dto.MovimientoStockDTO;
import tfg.muffinmanager.api.rest_service.modelo.dto.ReservaStockDTO;
import tfg.muffinmanager.api.rest_service.modelo.dto.SalidaStockDTO;
import tfg.muffinmanager.api.rest_service.modelo.dto.StockProductoDTO;
import tfg.muffinmanager.api.rest_service.modelo.dto.StockProductoDTOMovimientos;
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

    @GetMapping("/movimiento/detalle")
    public ArrayList<StockProductoDTOMovimientos> obtenerStockProductoConMovimientos() {
        return stockProductoServicio.obtenerStockProductoConMovimientos();
    }

    @GetMapping("/movimiento")
    public ArrayList<MovimientoStockDTO> obtenerMovimientosStock() {
        return stockProductoServicio.obtenerMovimientosStock();
    }

    @PostMapping("/movimiento")
    public MovimientoStockDTO guardarMovimientoStock(@RequestBody MovimientoStockDTO movimientoStockDTO) {
        return stockProductoServicio.guardarMovimientoStock(movimientoStockDTO);
    }

    @PostMapping("/movimiento/entrada")
    public MovimientoStockDTO guardarEntradaStock(@RequestBody MovimientoStockDTO movimientoStockDTO) {
        return stockProductoServicio.guardarEntradaStock(movimientoStockDTO);
    }
    @PostMapping("/movimiento/ajuste")
    public MovimientoStockDTO guardarAjusteStock(@RequestBody MovimientoStockDTO movimientoStockDTO) {
        return stockProductoServicio.guardarAjusteStock(movimientoStockDTO);
    }
    @PostMapping("/movimiento/salida")
    public MovimientoStockDTO guardarSalidaStock(@RequestBody SalidaStockDTO movimientoStockDTO) {
        return stockProductoServicio.guardarSalidaStock(movimientoStockDTO);
    }
    @PostMapping("/movimiento/reserva")
    public MovimientoStockDTO guardarReservaStock(@RequestBody ReservaStockDTO movimientoStockDTO) {
        return stockProductoServicio.guardarReservaStock(movimientoStockDTO);
    }
}
