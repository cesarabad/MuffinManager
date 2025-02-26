package tfg.muffinmanager.api.rest_service.modelo.dto;

import java.time.LocalDateTime;

public class ArticuloDTO {

    private String referencia;
    private String marca;
    private String forma;
    private String descripcion;
    private Float peso;
    private Integer unidadesPorArticulo;
    private String ean13;
    private Integer lineaProduccion;
    private int version;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaFin;
    private boolean activo;
    private String responsable;

    public ArticuloDTO() {
    }

    public ArticuloDTO(String referencia, String marca, String forma, String descripcion, Float peso, Integer unidadesPorArticulo,
            String ean13, Integer lineaProduccion, int version, LocalDateTime fechaCreacion, LocalDateTime fechaFin,
            boolean activo, String responsable) {
        this.referencia = referencia;
        this.marca = marca;
        this.forma = forma;
        this.descripcion = descripcion;
        this.peso = peso;
        this.unidadesPorArticulo = unidadesPorArticulo;
        this.ean13 = ean13;
        this.lineaProduccion = lineaProduccion;
        this.version = version;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getForma() {
        return forma;
    }

    public void setForma(String forma) {
        this.forma = forma;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    public Integer getUnidadesPorArticulo() {
        return unidadesPorArticulo;
    }

    public void setUnidadesPorArticulo(Integer unidadesPorArticulo) {
        this.unidadesPorArticulo = unidadesPorArticulo;
    }

    public String getEan13() {
        return ean13;
    }

    public void setEan13(String ean13) {
        this.ean13 = ean13;
    }

    public Integer getLineaProduccion() {
        return lineaProduccion;
    }

    public void setLineaProduccion(Integer lineaProduccion) {
        this.lineaProduccion = lineaProduccion;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
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
