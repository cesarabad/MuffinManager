package tfg.muffinmanager.api.rest_service.servicios.interfaces;

import java.util.ArrayList;

import tfg.muffinmanager.api.rest_service.modelo.dto.MovimientoStockDTO;
import tfg.muffinmanager.api.rest_service.modelo.dto.ReservaStockDTO;
import tfg.muffinmanager.api.rest_service.modelo.dto.SalidaStockDTO;
import tfg.muffinmanager.api.rest_service.modelo.dto.StockProductoDTO;
import tfg.muffinmanager.api.rest_service.modelo.dto.StockProductoDTOMovimientos;
import tfg.muffinmanager.api.rest_service.modelo.entidades.StockProducto;
import tfg.muffinmanager.api.rest_service.modelo.entidades.ids.StockProductoId;

public interface StockProductoServicio {
    public StockProductoDTO crearStockProducto(StockProductoDTO stockProductoDTO);
    public ArrayList<StockProductoDTO> obtenerStockProductos();
    public StockProducto obtenerPorId(StockProductoId id);
    public ArrayList<StockProductoDTOMovimientos> obtenerStockProductoConMovimientos();
    public MovimientoStockDTO guardarMovimientoStock(MovimientoStockDTO movimientoStockDTO);
    public ArrayList<MovimientoStockDTO> obtenerMovimientosStock();
    public MovimientoStockDTO guardarEntradaStock(MovimientoStockDTO movimientoStockDTO);
    public MovimientoStockDTO guardarAjusteStock(MovimientoStockDTO movimientoStockDTO);
    public MovimientoStockDTO guardarSalidaStock(SalidaStockDTO movimientoStockDTO);
    public MovimientoStockDTO guardarReservaStock(ReservaStockDTO movimientoStockDTO);
}
