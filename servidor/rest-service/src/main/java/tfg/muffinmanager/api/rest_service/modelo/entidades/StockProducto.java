package tfg.muffinmanager.api.rest_service.modelo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import tfg.muffinmanager.api.rest_service.modelo.dto.StockProductoDTO;
import tfg.muffinmanager.api.rest_service.modelo.entidades.ids.StockProductoId;

@Entity
@Table(name = "stock_producto")
@IdClass(StockProductoId.class)
public class StockProducto {

    @Id
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "producto", referencedColumnName = "referencia"),
        @JoinColumn(name = "versionproducto", referencedColumnName = "version")
    })
    private Producto producto;
    @Id
    @Column(length = 5)
    private String lote;
    @Id
    @ManyToOne
    @JoinColumn(name = "impresionpaquete", referencedColumnName = "abreviatura")
    private ImpresionPaquete impresionPaquete;

    private int unidades;
    public StockProducto() {
    }

    public StockProducto(Producto producto, String lote, ImpresionPaquete impresionPaquete, int unidades) {
        this.producto = producto;
        this.lote = lote;
        this.impresionPaquete = impresionPaquete;
        this.unidades = unidades;
    }

    public StockProductoDTO toDto() {
        return new StockProductoDTO(producto.getReferencia(), lote, impresionPaquete.getAbreviatura(), unidades);
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public ImpresionPaquete getImpresionPaquete() {
        return impresionPaquete;
    }

    public void setImpresionPaquete(ImpresionPaquete impresionPaquete) {
        this.impresionPaquete = impresionPaquete;
    }
    public int getUnidades() {
        return unidades;
    }
    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    
}
