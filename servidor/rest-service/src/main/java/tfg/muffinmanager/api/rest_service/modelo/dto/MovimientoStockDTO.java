package tfg.muffinmanager.api.rest_service.modelo.dto;

import java.time.LocalDateTime;

public class MovimientoStockDTO {

    protected String tipo;
    private int numero;
    private String producto;
    private String lote;
    private String impresionPaquete;
    private String responsable;
    private int unidades;
    private LocalDateTime fechaYHora;
    private String observaciones;

    public MovimientoStockDTO() {
    }

    public MovimientoStockDTO(String tipo, int numero, String producto, String lote, String impresionPaquete, String responsable, LocalDateTime fechaYHora, int unidades, String observaciones) {
        this.tipo = tipo;
        this.numero = numero;
        this.producto = producto;
        this.lote = lote;
        this.impresionPaquete = impresionPaquete;
        this.responsable = responsable;
        this.fechaYHora = fechaYHora;
        this.unidades = unidades;
        this.observaciones = observaciones;
    }
    @Override
    public String toString() {
        return "MovimientoStockDTO{" +
                "tipo='" + tipo + '\'' +
                "numero=" + numero +
                ", producto='" + producto + '\'' +
                ", lote='" + lote + '\'' +
                ", impresionPaquete='" + impresionPaquete + '\'' +
                ", responsable='" + responsable + '\'' +
                ", fechaYHora=" + fechaYHora +
                ", unidades=" + unidades +
                ", observaciones='" + observaciones + '\'' +
                '}';
    }
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
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

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
