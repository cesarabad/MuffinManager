package tfg.muffinmanager.api.rest_service.servicios;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfg.muffinmanager.api.rest_service.modelo.dto.MovimientoStockDTO;
import tfg.muffinmanager.api.rest_service.modelo.dto.ReservaStockDTO;
import tfg.muffinmanager.api.rest_service.modelo.dto.SalidaStockDTO;
import tfg.muffinmanager.api.rest_service.modelo.dto.StockProductoDTO;
import tfg.muffinmanager.api.rest_service.modelo.dto.StockProductoDTOMovimientos;
import tfg.muffinmanager.api.rest_service.modelo.entidades.AjusteStock;
import tfg.muffinmanager.api.rest_service.modelo.entidades.EntradaStock;
import tfg.muffinmanager.api.rest_service.modelo.entidades.MovimientoStock;
import tfg.muffinmanager.api.rest_service.modelo.entidades.ReservaStock;
import tfg.muffinmanager.api.rest_service.modelo.entidades.SalidaStock;
import tfg.muffinmanager.api.rest_service.modelo.entidades.StockProducto;
import tfg.muffinmanager.api.rest_service.modelo.entidades.ids.StockProductoId;
import tfg.muffinmanager.api.rest_service.repositorios.MovimientoStockRepositorio;
import tfg.muffinmanager.api.rest_service.repositorios.StockProductoRepositorio;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.ImpresionPaqueteServicio;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.ProductoServicio;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.StockProductoServicio;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.UsuarioServicio;

@Service
public class StockProductoServicioImpl implements StockProductoServicio {
    @Autowired
    StockProductoRepositorio stockProductoRepositorio;
    @Autowired
    ProductoServicio productoServicio;
    @Autowired
    ImpresionPaqueteServicio impresionPaqueteServicio;
    @Autowired
    MovimientoStockRepositorio movimientoStockRepositorio;
    @Autowired
    UsuarioServicio usuarioServicio;

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
            ArrayList<MovimientoStockDTO> movimientos = obtenerMovimientosStock();
            
            stockProductoDTOMovimientos.add(new StockProductoDTOMovimientos(stockProducto.getProducto(), stockProducto.getLote(), stockProducto.getImpresionPaquete(), stockProducto.getUnidades(), movimientos));
            
        }
        
        return stockProductoDTOMovimientos;
    }

    @Override
    public MovimientoStockDTO guardarMovimientoStock(MovimientoStockDTO movimientoStock) {
        StockProducto stockProducto = obtenerPorId(
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

    @Override
    public MovimientoStockDTO guardarEntradaStock(MovimientoStockDTO movimientoStock) {
        StockProducto stockProducto = obtenerPorId(
            new StockProductoId(productoServicio.obtenerProductoPorReferencia(
                movimientoStock.getProducto())
                ,movimientoStock.getLote()
                ,impresionPaqueteServicio.obtenerPorAbreviatura(movimientoStock.getImpresionPaquete())));

        MovimientoStock movimiento = new EntradaStock(movimientoStock.getNumero()
        ,stockProducto
        ,usuarioServicio.dtoToUsuario(usuarioServicio.obtenerPorDni(movimientoStock.getResponsable()))
        ,Timestamp.valueOf(movimientoStock.getFechaYHora()),movimientoStock.getUnidades(),movimientoStock.getObservaciones()); 

        return movimientoStockRepositorio.save(movimiento).toDto();
    }

    @Override
    public MovimientoStockDTO guardarAjusteStock(MovimientoStockDTO movimientoStock) {
        StockProducto stockProducto = obtenerPorId(
            new StockProductoId(productoServicio.obtenerProductoPorReferencia(
                movimientoStock.getProducto())
                ,movimientoStock.getLote()
                ,impresionPaqueteServicio.obtenerPorAbreviatura(movimientoStock.getImpresionPaquete())));

        MovimientoStock movimiento = new AjusteStock(movimientoStock.getNumero()
        ,stockProducto
        ,usuarioServicio.dtoToUsuario(usuarioServicio.obtenerPorDni(movimientoStock.getResponsable()))
        ,Timestamp.valueOf(movimientoStock.getFechaYHora()),movimientoStock.getUnidades(),movimientoStock.getObservaciones()); 

        return movimientoStockRepositorio.save(movimiento).toDto();
    }

    @Override
    public MovimientoStockDTO guardarSalidaStock(SalidaStockDTO movimientoStock) {
        StockProducto stockProducto = obtenerPorId(
            new StockProductoId(productoServicio.obtenerProductoPorReferencia(
                movimientoStock.getProducto())
                ,movimientoStock.getLote()
                ,impresionPaqueteServicio.obtenerPorAbreviatura(movimientoStock.getImpresionPaquete())));

        MovimientoStock movimiento = new SalidaStock(movimientoStock.getNumero()
        ,stockProducto
        ,usuarioServicio.dtoToUsuario(usuarioServicio.obtenerPorDni(movimientoStock.getResponsable()))
        ,Timestamp.valueOf(movimientoStock.getFechaYHora()),movimientoStock.getUnidades(),movimientoStock.getObservaciones(), movimientoStock.getDestino()); 

        return movimientoStockRepositorio.save(movimiento).toDto();
    }

    @Override
    public MovimientoStockDTO guardarReservaStock(ReservaStockDTO movimientoStock) {
        StockProducto stockProducto = obtenerPorId(
            new StockProductoId(productoServicio.obtenerProductoPorReferencia(
                movimientoStock.getProducto())
                ,movimientoStock.getLote()
                ,impresionPaqueteServicio.obtenerPorAbreviatura(movimientoStock.getImpresionPaquete())));

        MovimientoStock movimiento = new ReservaStock(movimientoStock.getNumero()
        ,stockProducto
        ,usuarioServicio.dtoToUsuario(usuarioServicio.obtenerPorDni(movimientoStock.getResponsable()))
        ,Timestamp.valueOf(movimientoStock.getFechaYHora()),movimientoStock.getUnidades(),movimientoStock.getObservaciones(), movimientoStock.getDestino()); 

        return movimientoStockRepositorio.save(movimiento).toDto();
    }
}
