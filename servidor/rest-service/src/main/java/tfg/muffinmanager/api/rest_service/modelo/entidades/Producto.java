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
import tfg.muffinmanager.api.rest_service.modelo.dto.ProductoDTO;
import tfg.muffinmanager.api.rest_service.modelo.entidades.ids.ProductoId;

@Entity
@Table(name = "producto")
@IdClass(ProductoId.class)
public class Producto {

    @Id
    @Column(length = 20)
    private String referencia;
    @Id
    private int version;
    @ManyToOne
    @JoinColumn(name = "caja", referencedColumnName = "env")
    private Caja caja;
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "articulo", referencedColumnName = "referencia"),
        @JoinColumn(name = "versionarticulo", referencedColumnName = "version")
    })
    private Articulo articulo;
    @Column(name = "articuloporcaja")
    private Integer articulosPorCaja;
    @Column(length = 14, unique = true)
    private String ean14;
    @Column(name = "fechacreacion", nullable = false)
    private Timestamp fechaCreacion;
    @Column(name = "fechafin")
    private Timestamp fechaFin;
    private boolean activo;
    @ManyToOne
    @JoinColumn(name = "responsable")
    private Usuario responsable;

    public Producto() {
    }

    public Producto(String referencia, Caja caja, Articulo articulo, Integer articulosPorCaja, String ean14, int version,
            Timestamp fechaCreacion, Timestamp fechaFin, boolean activo, Usuario responsable) {
        this.referencia = referencia;
        this.caja = caja;
        this.articulo = articulo;
        this.articulosPorCaja = articulosPorCaja;
        this.ean14 = ean14;
        this.version = version;
        this.fechaCreacion = fechaCreacion;
        this.fechaFin = fechaFin;
        this.activo = activo;
        this.responsable = responsable;
    }

    public ProductoDTO toDto() {
        return new ProductoDTO(referencia, version, caja.getEnv(), articulo.getReferencia(), articulosPorCaja, ean14,
                fechaCreacion.toLocalDateTime(), fechaFin != null ? fechaFin.toLocalDateTime() : null, activo,
                responsable.getDni());
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Caja getCaja() {
        return caja;
    }

    public void setCaja(Caja caja) {
        this.caja = caja;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Timestamp getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Timestamp fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Timestamp getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Timestamp fechaFin) {
        this.fechaFin = fechaFin;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Usuario getResponsable() {
        return responsable;
    }

    public void setResponsable(Usuario responsable) {
        this.responsable = responsable;
    }
}
