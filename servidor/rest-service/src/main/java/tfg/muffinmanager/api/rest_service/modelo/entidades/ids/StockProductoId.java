package tfg.muffinmanager.api.rest_service.modelo.entidades.ids;

import tfg.muffinmanager.api.rest_service.modelo.entidades.ImpresionPaquete;
import tfg.muffinmanager.api.rest_service.modelo.entidades.Producto;

public class StockProductoId {

    Producto producto;
    String lote;
    ImpresionPaquete impresionPaquete;

    public StockProductoId() {
    }

    public StockProductoId(Producto producto, String lote, ImpresionPaquete impresionPaquete) {
        this.producto = producto;
        this.lote = lote;
        this.impresionPaquete = impresionPaquete;
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
}
