package tfg.muffinmanager.api.rest_service.modelo.entidades;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import tfg.muffinmanager.api.rest_service.modelo.dto.FormaDTO;

@Entity
@Table(name = "forma")
public class Forma {
    @Id
    @Column(name="id", length = 10)
    private String idForma;
    @Column(length = 80, nullable = false)
    private String descripcion;
    private int version;
    @Column(name="fechacreacion", nullable = false)
    private Timestamp fechaCreacion;
    @Column(name="fechafin")
    private Timestamp fechaFin;
    private boolean activo;
    @ManyToOne
    @JoinColumn(name = "responsable", nullable = false)
    private Usuario responsable;


    public Forma() {
    }

    public Forma(String id, String descripcion, int version, Timestamp fechaCreacion, Timestamp fechaFin,
            boolean activo, Usuario responsable) {
        this.idForma = id;
        this.descripcion = descripcion;
        this.version = version;
        this.fechaCreacion = fechaCreacion;
        this.fechaFin = fechaFin;
        this.activo = activo;
        this.responsable = responsable;
    }

    public FormaDTO toDto() {
        return new FormaDTO(idForma, descripcion, version, fechaCreacion.toLocalDateTime(),fechaFin != null ? fechaFin.toLocalDateTime() : null, activo, responsable.getDni());
    }

    public String getIdForma() {
        return idForma;
    }

    public void setIdForma(String idForma) {
        this.idForma = idForma;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
