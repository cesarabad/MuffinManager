package tfg.muffinmanager.api.rest_service.modelo.dto;

import java.util.ArrayList;

public class StockProductoDTOMovimientos extends StockProductoDTO{

    private ArrayList<MovimientoStockDTO> movimientos;

    public StockProductoDTOMovimientos() {
    }

    public StockProductoDTOMovimientos(String referencia, String lote, String impresionPaquete, int unidades, ArrayList<MovimientoStockDTO> movimientos) {
        super(referencia, lote, impresionPaquete, unidades);
        this.movimientos = movimientos;
    }

    public ArrayList<MovimientoStockDTO> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(ArrayList<MovimientoStockDTO> movimientos) {
        this.movimientos = movimientos;
    }
}
