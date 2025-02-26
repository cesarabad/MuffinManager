package tfg.muffinmanager.api.rest_service.modelo.entidades;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import tfg.muffinmanager.api.rest_service.modelo.dto.ArticuloDTO;

@Entity
@Table(name = "articulo")
public class Articulo {

    @Id
    private String referencia;
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "marca", referencedColumnName = "id"),
        @JoinColumn(name = "versionmarca", referencedColumnName = "version")
    })
    private Marca marca;
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "forma", referencedColumnName = "id"),
        @JoinColumn(name = "versionforma", referencedColumnName = "version")
    })
    private Forma forma;
    @Column(name="descripcionmain", length = 80, nullable = false)
    private String descripcion;
    private Float peso;
    @Column(name = "unidadesporarticulo")
    private Integer unidadesPorArticulo;
    @Column(length = 13, unique = true)
    private String ean13;
    @Column(name = "lineaproduccion")
    private Integer lineaProduccion;
    private int version;
    @Column(name = "fechacreacion", nullable = false)
    private Timestamp fechaCreacion;
    @Column(name = "fechafin")
    private Timestamp fechaFin;
    private boolean activo;    
    @ManyToOne
    @JoinColumn(name = "responsable", nullable = false)
    private Usuario responsable;

    public Articulo() {
    }

    public Articulo(String referencia, Marca marca, Forma forma, String descripcion, Float peso, Integer unidadesPorArticulo,
            String ean13, Integer lineaProduccion, int version, Timestamp fechaCreacion, Timestamp fechaFin,
            boolean activo, Usuario responsable) {
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

    public ArticuloDTO toDto() {
        return new ArticuloDTO(referencia, marca.getId(), forma.getIdForma(), descripcion, peso, unidadesPorArticulo, ean13, lineaProduccion, version, fechaCreacion.toLocalDateTime(), fechaFin != null ? fechaFin.toLocalDateTime() : null, activo, responsable.getDni());
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Forma getForma() {
        return forma;
    }

    public void setForma(Forma forma) {
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
