package tfg.muffinmanager.api.rest_service.modelo.entidades;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import tfg.muffinmanager.api.rest_service.modelo.dto.MovimientoStockDTO;
import tfg.muffinmanager.api.rest_service.modelo.entidades.ids.MovimientoStockId;

@Entity
@Table(name = "movimiento_stock")
@IdClass(MovimientoStockId.class)
public class MovimientoStock {

    @Id
    private int numero;
    @Id
    @ManyToOne
    @JoinColumns({
        @jakarta.persistence.JoinColumn(name = "producto", referencedColumnName = "producto"),
        @jakarta.persistence.JoinColumn(name = "versionproducto", referencedColumnName = "versionproducto"),
        @jakarta.persistence.JoinColumn(name = "lote", referencedColumnName = "lote"),
        @jakarta.persistence.JoinColumn(name = "impresionpaquete", referencedColumnName = "impresionpaquete")
    })
    private StockProducto stockProducto;
    @JoinColumn(name = "responsable")
    @ManyToOne
    private Usuario responsable;
    @Column(name = "fechayhora", nullable = false)
    private Timestamp fechaYHora;
    private String observaciones;

    public MovimientoStock() {
    }

    public MovimientoStock(int numero, StockProducto stockProducto, Usuario responsable, Timestamp fechaYHora,
            String observaciones) {
        this.numero = numero;
        this.stockProducto = stockProducto;
        this.responsable = responsable;
        this.fechaYHora = fechaYHora;
        this.observaciones = observaciones;
    }

    public MovimientoStockDTO toDto() {
        return new MovimientoStockDTO(numero, stockProducto.getProducto().getReferencia(),
                stockProducto.getLote(), stockProducto.getImpresionPaquete().getAbreviatura(), responsable.getDni(),
                fechaYHora.toLocalDateTime(), observaciones);
    }
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public StockProducto getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(StockProducto stockProducto) {
        this.stockProducto = stockProducto;
    }

    public Usuario getResponsable() {
        return responsable;
    }

    public void setResponsable(Usuario responsable) {
        this.responsable = responsable;
    }

    public Timestamp getFechaYHora() {
        return fechaYHora;
    }
    public void setFechaYHora(Timestamp fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
