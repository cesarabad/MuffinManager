package tfg.muffinmanager.api.rest_service.modelo.entidades;


import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.PrimaryKeyJoinColumns;
import jakarta.persistence.Table;
import tfg.muffinmanager.api.rest_service.modelo.dto.MovimientoStockDTO;
import tfg.muffinmanager.api.rest_service.modelo.dto.SalidaStockDTO;

@Entity
@Table(name = "salida_stock")
@PrimaryKeyJoinColumns({
    @PrimaryKeyJoinColumn(name = "numero", referencedColumnName = "numero"),
    @PrimaryKeyJoinColumn(name = "producto", referencedColumnName = "producto"),
    @PrimaryKeyJoinColumn(name = "versionproducto", referencedColumnName = "versionproducto"),
    @PrimaryKeyJoinColumn(name = "lote", referencedColumnName = "lote"),
    @PrimaryKeyJoinColumn(name = "impresionpaquete", referencedColumnName = "impresionpaquete")
})

public class SalidaStock extends MovimientoStock {

    private String destino;

    public SalidaStock() {
    }

    public SalidaStock(int numero, StockProducto stockProducto, int unidades, String destino) {
        this.numero = numero;
        this.stockProducto = stockProducto;
        this.unidades = unidades;
        this.destino = destino;
    }
    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    @Override
    public MovimientoStockDTO toDto() {
        return new SalidaStockDTO("SalidaStock",numero
        , stockProducto.getProducto().getReferencia()
        , stockProducto.getLote()
        ,stockProducto.getImpresionPaquete().getAbreviatura()
        ,responsable.getDni()
        , fechaYHora.toLocalDateTime()
        , unidades
        , observaciones
        , destino);
    }
}
