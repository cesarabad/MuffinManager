package tfg.muffinmanager.api.rest_service.modelo.dto;

public class StockProductoDTO {

    private String producto;
    private String lote;
    private String impresionPaquete;
    private int unidades;

    public StockProductoDTO() {
    }
    public StockProductoDTO(String producto, String lote, String impresionPaquete, int unidades) {
        this.producto = producto;
        this.lote = lote;
        this.impresionPaquete = impresionPaquete;
        this.unidades = unidades;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getImpresionPaquete() {
        return impresionPaquete;
    }

    public void setImpresionPaquete(String impresionPaquete) {
        this.impresionPaquete = impresionPaquete;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
}
