package tfg.muffinmanager.api.rest_service.modelo.dto;

import java.time.LocalDateTime;

public class ProductoDTO {

    private String referencia;
    private int version;
    private String caja;
    private String articulo;
    private Integer articulosPorCaja;
    private String ean14;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaFin;
    private boolean activo;
    private String responsable;

    public ProductoDTO() {
    }

    public ProductoDTO(String referencia, int version, String caja, String articulo, Integer articulosPorCaja, String ean14,
            LocalDateTime fechaCreacion, LocalDateTime fechaFin, boolean activo, String responsable) {
        this.referencia = referencia;
        this.version = version;
        this.caja = caja;
        this.articulo = articulo;
        this.articulosPorCaja = articulosPorCaja;
        this.ean14 = ean14;
        this.fechaCreacion = fechaCreacion;
        this.fechaFin = fechaFin;
        this.activo = activo;
        this.responsable = responsable;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getCaja() {
        return caja;
    }

    public void setCaja(String caja) {
        this.caja = caja;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public Integer getArticulosPorCaja() {
        return articulosPorCaja;
    }

    public void setArticulosPorCaja(Integer articulosPorCaja) {
        this.articulosPorCaja = articulosPorCaja;
    }

    public String getEan14() {
        return ean14;
    }

    public void setEan14(String ean14) {
        this.ean14 = ean14;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
}
