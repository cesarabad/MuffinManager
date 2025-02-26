package tfg.muffinmanager.api.rest_service.modelo.dto;

import java.time.LocalDateTime;

public class FormaDTO {

    private String id;
    private String descripcion;
    private int version;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaFin;
    private boolean activo;
    private String responsable;

    public FormaDTO() {
    }

    public FormaDTO(String id, String descripcion, int version, LocalDateTime fechaCreacion, LocalDateTime fechaFin,
            boolean activo, String responsable) {
        this.id = id;
        this.descripcion = descripcion;
        this.version = version;
        this.fechaCreacion = fechaCreacion;
        this.fechaFin = fechaFin;
        this.activo = activo;
        this.responsable = responsable;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
