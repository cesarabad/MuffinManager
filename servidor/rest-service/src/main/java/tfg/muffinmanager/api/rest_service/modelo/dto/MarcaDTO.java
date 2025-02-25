package tfg.muffinmanager.api.rest_service.modelo.dto;

import java.time.LocalDateTime;

public class MarcaDTO {

    private String id;
    private String nombre;
    private byte[] logo;
    private int version;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaFin;
    private boolean activo;
    private UsuarioDTO responsable;

    public MarcaDTO() {
    }

    public MarcaDTO(String id, String nombre, byte[] logo, int version, LocalDateTime fechaCreacion, LocalDateTime fechaFin,
            boolean activo, UsuarioDTO responsable) {
        this.id = id;
        this.nombre = nombre;
        this.logo = logo;
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

    public UsuarioDTO getResponsable() {
        return responsable;
    }

    public void setResponsable(UsuarioDTO responsable) {
        this.responsable = responsable;
    }
}
