package tfg.muffinmanager.api.rest_service.modelo.entidades;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import tfg.muffinmanager.api.rest_service.modelo.dto.MovimientoStockDTO;
import tfg.muffinmanager.api.rest_service.modelo.entidades.ids.MovimientoStockId;

@Entity
@Table(name = "movimiento_stock")
@IdClass(MovimientoStockId.class)
@Inheritance(strategy = InheritanceType.JOINED)
public class MovimientoStock {

    @Id
    protected int numero;
    @Id
    @ManyToOne
    @JoinColumns({
        @jakarta.persistence.JoinColumn(name = "producto", referencedColumnName = "producto"),
        @jakarta.persistence.JoinColumn(name = "versionproducto", referencedColumnName = "versionproducto"),
        @jakarta.persistence.JoinColumn(name = "lote", referencedColumnName = "lote"),
        @jakarta.persistence.JoinColumn(name = "impresionpaquete", referencedColumnName = "impresionpaquete")
    })
    protected StockProducto stockProducto;
    @JoinColumn(name = "responsable")
    @ManyToOne
    protected Usuario responsable;
    @Column(name = "fechayhora", nullable = false)
    protected Timestamp fechaYHora;
    protected int unidades;
    protected String observaciones;

    public MovimientoStock() {
    }

    public MovimientoStock(int numero, StockProducto stockProducto, Usuario responsable, Timestamp fechaYHora,
            int unidades,String observaciones) {
        this.numero = numero;
        this.stockProducto = stockProducto;
        this.responsable = responsable;
        this.fechaYHora = fechaYHora;
        this.unidades = unidades;
        this.observaciones = observaciones;
    }

    public MovimientoStockDTO toDto() {
        return new MovimientoStockDTO("MovimientoStock", numero, stockProducto.getProducto().getReferencia(),
                stockProducto.getLote(), stockProducto.getImpresionPaquete().getAbreviatura(), responsable.getDni(),
                fechaYHora.toLocalDateTime(),unidades, observaciones);
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

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
