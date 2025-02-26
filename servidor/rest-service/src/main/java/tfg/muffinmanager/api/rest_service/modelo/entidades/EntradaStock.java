package tfg.muffinmanager.api.rest_service.modelo.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.PrimaryKeyJoinColumns;
import jakarta.persistence.Table;
import tfg.muffinmanager.api.rest_service.modelo.dto.MovimientoStockDTO;

@Entity
@Table(name = "entrada_stock")
@PrimaryKeyJoinColumns({
    @PrimaryKeyJoinColumn(name = "numero", referencedColumnName = "numero"),
    @PrimaryKeyJoinColumn(name = "producto", referencedColumnName = "producto"),
    @PrimaryKeyJoinColumn(name = "versionproducto", referencedColumnName = "versionproducto"),
    @PrimaryKeyJoinColumn(name = "lote", referencedColumnName = "lote"),
    @PrimaryKeyJoinColumn(name = "impresionpaquete", referencedColumnName = "impresionpaquete")
})
public class EntradaStock extends MovimientoStock {

    public EntradaStock() {
    }

    public EntradaStock(int numero, StockProducto stockProducto, int unidades) {
        this.numero = numero;
        this.stockProducto = stockProducto;
        this.unidades = unidades;
    }

    @Override
    public MovimientoStockDTO toDto() {
        return new MovimientoStockDTO("EntradaStock",numero
        , stockProducto.getProducto().getReferencia()
        , stockProducto.getLote()
        ,stockProducto.getImpresionPaquete().getAbreviatura()
        ,responsable.getDni()
        , fechaYHora.toLocalDateTime()
        , unidades
        , observaciones);
    }
}
