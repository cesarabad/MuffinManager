package tfg.muffinmanager.api.rest_service.servicios.interfaces;

import java.util.ArrayList;

import tfg.muffinmanager.api.rest_service.modelo.dto.MovimientoStockDTO;

public interface MovimientoStockServicio {
    public MovimientoStockDTO guardarMovimientoStock(MovimientoStockDTO movimientoStockDTO);
    public ArrayList<MovimientoStockDTO> obtenerMovimientosStock();
}
