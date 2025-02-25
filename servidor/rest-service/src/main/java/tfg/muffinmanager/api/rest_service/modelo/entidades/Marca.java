package tfg.muffinmanager.api.rest_service.modelo.entidades;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import tfg.muffinmanager.api.rest_service.modelo.dto.MarcaDTO;

@Entity
@Table(name = "marca")
public class Marca {
    @Id
    @Column(name="id", length = 10)
    private String idMarca;
    @Column(length = 80, nullable = false)
    private String nombre;
    private byte[] logo;
    private int version; 
    @Column(name="fechacreacion", nullable = false)
    private Timestamp fechaCreacion;
    @Column(name="fechafin")
    private Timestamp fechaFin;
    private boolean activo;
    @ManyToOne
    @JoinColumn(name = "responsable", nullable = false)
    private Usuario responsable;

    public Marca() {
    }

    public Marca(String id, String nombre, byte[] logo, int version, Timestamp fechaCreacion, Timestamp fechaFin,
            boolean activo, Usuario responsable) {
        this.idMarca = id;
        this.nombre = nombre;
        this.logo = logo;
        this.version = version;
        this.fechaCreacion = fechaCreacion;
        this.fechaFin = fechaFin;
        this.activo = activo;
        this.responsable = responsable;
    }

    public MarcaDTO toDTO() {
        return new MarcaDTO(idMarca, nombre, logo, version, fechaCreacion.toLocalDateTime(),fechaFin != null ? fechaFin.toLocalDateTime() : null, activo, responsable.toDTO());
    }

    public String getId() {
        return idMarca;
    }

    public void setId(String id) {
        this.idMarca = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
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
