package tfg.muffinmanager.api.rest_service.servicios;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfg.muffinmanager.api.rest_service.modelo.dto.MovimientoStockDTO;
import tfg.muffinmanager.api.rest_service.modelo.entidades.MovimientoStock;
import tfg.muffinmanager.api.rest_service.modelo.entidades.StockProducto;
import tfg.muffinmanager.api.rest_service.modelo.entidades.ids.StockProductoId;
import tfg.muffinmanager.api.rest_service.repositorios.MovimientoStockRepositorio;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.ImpresionPaqueteServicio;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.MovimientoStockServicio;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.ProductoServicio;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.StockProductoServicio;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.UsuarioServicio;

@Service
public class MovimientoStockServicioImpl implements MovimientoStockServicio {

    @Autowired
    MovimientoStockRepositorio movimientoStockRepositorio;
    @Autowired
    ProductoServicio productoServicio;
    @Autowired
    ImpresionPaqueteServicio impresionPaqueteServicio;
    @Autowired
    UsuarioServicio usuarioServicio;
    @Autowired
    StockProductoServicio stockProductoServicio;
    
    //int numero, StockProducto stockProducto, Usuario responsable, Timestamp fechaYHora, String observaciones
    @Override
    public MovimientoStockDTO guardarMovimientoStock(MovimientoStockDTO movimientoStock) {
        StockProducto stockProducto = stockProductoServicio.obtenerPorId(
            new StockProductoId(productoServicio.obtenerProductoPorReferencia(
                movimientoStock.getProducto())
                ,movimientoStock.getLote()
                ,impresionPaqueteServicio.obtenerPorAbreviatura(movimientoStock.getImpresionPaquete())));

        MovimientoStock movimiento = new MovimientoStock(movimientoStock.getNumero()
        ,stockProducto
        ,usuarioServicio.dtoToUsuario(usuarioServicio.obtenerPorDni(movimientoStock.getResponsable()))
        ,Timestamp.valueOf(movimientoStock.getFechaYHora()),movimientoStock.getUnidades(),movimientoStock.getObservaciones()); 

        return movimientoStockRepositorio.save(movimiento).toDto();
    }

   

    @Override
    public ArrayList<MovimientoStockDTO> obtenerMovimientosStock() {
        ArrayList<MovimientoStockDTO> movimientos = new ArrayList<>();
        movimientoStockRepositorio.findAll().forEach(movimiento -> {
            movimientos.add(movimiento.toDto());
        });
        return movimientos;
    }

}
