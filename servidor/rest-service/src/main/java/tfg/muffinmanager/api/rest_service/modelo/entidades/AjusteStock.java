package tfg.muffinmanager.api.rest_service.modelo.entidades;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.PrimaryKeyJoinColumns;
import jakarta.persistence.Table;
import tfg.muffinmanager.api.rest_service.modelo.dto.MovimientoStockDTO;

@Entity
@Table(name = "ajuste_stock")
@PrimaryKeyJoinColumns({
    @PrimaryKeyJoinColumn(name = "numero", referencedColumnName = "numero"),
    @PrimaryKeyJoinColumn(name = "producto", referencedColumnName = "producto"),
    @PrimaryKeyJoinColumn(name = "versionproducto", referencedColumnName = "versionproducto"),
    @PrimaryKeyJoinColumn(name = "lote", referencedColumnName = "lote"),
    @PrimaryKeyJoinColumn(name = "impresionpaquete", referencedColumnName = "impresionpaquete")
})

public class AjusteStock extends MovimientoStock {

    
    public AjusteStock() {
    }

    public AjusteStock(int numero, StockProducto stockProducto, Usuario responsable, Timestamp fechaYHora, int unidades, String observaciones) {
        this.numero = numero;
        this.stockProducto = stockProducto;
        this.fechaYHora = fechaYHora;
        this.responsable = responsable;
        this.unidades = unidades;
        this.observaciones =observaciones;
    }

    @Override
    public MovimientoStockDTO toDto() {
        return new MovimientoStockDTO("AjusteStock",numero
        , stockProducto.getProducto().getReferencia()
        , stockProducto.getLote()
        ,stockProducto.getImpresionPaquete().getAbreviatura()
        ,responsable.getDni()
        , fechaYHora.toLocalDateTime()
        , unidades
        , observaciones);
    }

}
