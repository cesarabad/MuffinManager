package tfg.muffinmanager.api.rest_service.modelo.entidades.ids;

import java.util.Objects;

import tfg.muffinmanager.api.rest_service.modelo.entidades.StockProducto;

public class MovimientoStockId {

    private int numero;
    private StockProducto stockProducto;
    
    public MovimientoStockId() {
    }

    public MovimientoStockId(int numero, StockProducto stockProducto) {
        this.numero = numero;
        this.stockProducto = stockProducto;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MovimientoStockId other = (MovimientoStockId) obj;
        return numero == other.numero && stockProducto != null && stockProducto.equals(other.stockProducto);
            
    }

    @Override
    public int hashCode() {
        return Objects.hash(numero, stockProducto);
    }
}
