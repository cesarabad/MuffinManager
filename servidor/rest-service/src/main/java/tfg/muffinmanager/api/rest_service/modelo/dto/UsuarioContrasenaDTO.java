package tfg.muffinmanager.api.rest_service.modelo.dto;

import java.util.Set;

import tfg.muffinmanager.api.rest_service.modelo.entidades.GrupoPermisos;
import tfg.muffinmanager.api.rest_service.modelo.entidades.Permiso;

public class UsuarioContrasenaDTO {

    private UsuarioDTO usuarioDTO;
    private String contrasena;

    public UsuarioContrasenaDTO() {
    }

    public UsuarioContrasenaDTO(UsuarioDTO usuario, String contrasena) {
        this.usuarioDTO = usuario;
        this.contrasena = contrasena;
    }

    public UsuarioDTO getUsuarioDTO() {
        return usuarioDTO;
    }

    public void setUsuarioDTO(UsuarioDTO usuario) {
        this.usuarioDTO = usuario;
    }

    public String getDni() {
        return usuarioDTO.getDni();
    }

    public void setDni(String dni) {
        this.usuarioDTO.setDni(dni);
    }

    public String getNombre() {
        return usuarioDTO.getNombre();
    }

    public void setNombre(String nombre) {
        this.usuarioDTO.setNombre(nombre);
    }

    public String getApellidos() {
        return usuarioDTO.getApellidos();
    }

    public void setApellidos(String apellidos) {
        this.usuarioDTO.setApellidos(apellidos);
    }

    public String getNombreUsuario() {
        return usuarioDTO.getNombreUsuario();
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.usuarioDTO.setNombreUsuario(nombreUsuario);
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Set<GrupoPermisos> getGruposPermisos() {
        return this.usuarioDTO.getGruposPermisos();
    }

    public void setGruposPermisos(Set<GrupoPermisos> gruposPermisos) {
        this.usuarioDTO.setGruposPermisos(gruposPermisos);
    }

    public Set<Permiso> getPermisos() {
        return this.usuarioDTO.getPermisos();
    }

    public void setPermisos(Set<Permiso> permisos) {
        this.usuarioDTO.setPermisos(permisos);
    }
    
}
