package tfg.muffinmanager.api.rest_service.servicios.interfaces;

import java.util.ArrayList;

import tfg.muffinmanager.api.rest_service.modelo.dto.StockProductoDTO;
import tfg.muffinmanager.api.rest_service.modelo.entidades.StockProducto;
import tfg.muffinmanager.api.rest_service.modelo.entidades.ids.StockProductoId;

public interface StockProductoServicio {
    public StockProductoDTO crearStockProducto(StockProductoDTO stockProductoDTO);
    public ArrayList<StockProductoDTO> obtenerStockProductos();
    public StockProducto obtenerPorId(StockProductoId id);
}
