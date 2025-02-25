package tfg.muffinmanager.api.rest_service.modelo.dto;

import java.util.Set;

import tfg.muffinmanager.api.rest_service.modelo.entidades.GrupoPermisos;
import tfg.muffinmanager.api.rest_service.modelo.entidades.Permiso;

public class UsuarioDTO {

    private String dni;
    private String nombre;
    private String apellidos;
    private String nombreUsuario;
    private Set<GrupoPermisos> gruposPermisos;
    private Set<Permiso> permisos;

    public UsuarioDTO() {
    }
    public UsuarioDTO(String dni, String nombre, String apellidos, String nombreUsuario, Set<GrupoPermisos> gruposPermisos, Set<Permiso> permisos) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nombreUsuario = nombreUsuario;
        this.gruposPermisos = gruposPermisos;
        this.permisos = permisos;
    }

    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
    public Set<GrupoPermisos> getGruposPermisos() {
        return gruposPermisos;
    }

    public void setGruposPermisos(Set<GrupoPermisos> gruposPermisos) {
        this.gruposPermisos = gruposPermisos;
    }

    public Set<Permiso> getPermisos() {
        return permisos;
    }

    public void setPermisos(Set<Permiso> permisos) {
        this.permisos = permisos;
    }
}
