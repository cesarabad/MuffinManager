package tfg.muffinmanager.api.rest_service.servicios;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfg.muffinmanager.api.rest_service.modelo.dto.MovimientoStockDTO;
import tfg.muffinmanager.api.rest_service.modelo.dto.StockProductoDTO;
import tfg.muffinmanager.api.rest_service.modelo.dto.StockProductoDTOMovimientos;
import tfg.muffinmanager.api.rest_service.modelo.entidades.StockProducto;
import tfg.muffinmanager.api.rest_service.modelo.entidades.ids.StockProductoId;
import tfg.muffinmanager.api.rest_service.repositorios.StockProductoRepositorio;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.ImpresionPaqueteServicio;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.MovimientoStockServicio;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.ProductoServicio;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.StockProductoServicio;

@Service
public class StockProductoServicioImpl implements StockProductoServicio {
    @Autowired
    StockProductoRepositorio stockProductoRepositorio;
    @Autowired
    ProductoServicio productoServicio;
    @Autowired
    ImpresionPaqueteServicio impresionPaqueteServicio;
    @Autowired
    MovimientoStockServicio movimientoStockServicio;

    @Override
    public ArrayList<StockProductoDTO> obtenerStockProductos() {
        ArrayList<StockProductoDTO> stockProductos = new ArrayList<>();
        stockProductoRepositorio.findAll().forEach(stockProducto -> {
            stockProductos.add(new StockProductoDTO(stockProducto.getProducto().getReferencia(),
                    stockProducto.getLote(), stockProducto.getImpresionPaquete().getAbreviatura(),
                    stockProducto.getUnidades()));
        });
        return stockProductos;
    }

    @Override
    public StockProductoDTO crearStockProducto(StockProductoDTO stockProductoDTO) {
        return stockProductoRepositorio.save(new StockProducto(productoServicio.obtenerProductoPorReferencia(stockProductoDTO.getProducto()),
                stockProductoDTO.getLote(),impresionPaqueteServicio.obtenerPorAbreviatura(stockProductoDTO.getImpresionPaquete()) , stockProductoDTO.getUnidades())).toDto();
    }

    @Override
    public StockProducto obtenerPorId(StockProductoId id) {
        return stockProductoRepositorio.findById(id).get();
    }

    @Override
    public ArrayList<StockProductoDTOMovimientos> obtenerStockProductoConMovimientos() {
        
        ArrayList<StockProductoDTOMovimientos> stockProductoDTOMovimientos = new ArrayList<>();

        for (StockProductoDTO stockProducto : obtenerStockProductos()) {
            ArrayList<MovimientoStockDTO> movimientos = movimientoStockServicio.obtenerMovimientosStock();
            
            stockProductoDTOMovimientos.add(new StockProductoDTOMovimientos(stockProducto.getProducto(), stockProducto.getLote(), stockProducto.getImpresionPaquete(), stockProducto.getUnidades(), movimientos));
            
        }
        
        return stockProductoDTOMovimientos;
    }
}
