package tfg.muffinmanager.api.rest_service.modelo.dto;

public class UsuarioContrasenaDTO {

    private UsuarioDTO usuario;
    private String contrasena;

    public UsuarioContrasenaDTO() {
    }

    public UsuarioContrasenaDTO(UsuarioDTO usuario, String contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public String getDni() {
        return usuario.getDni();
    }

    public void setDni(String dni) {
        this.usuario.setDni(dni);
    }

    public String getNombre() {
        return usuario.getNombre();
    }

    public void setNombre(String nombre) {
        this.usuario.setNombre(nombre);
    }

    public String getApellidos() {
        return usuario.getApellidos();
    }

    public void setApellidos(String apellidos) {
        this.usuario.setApellidos(apellidos);
    }

    public String getNombreUsuario() {
        return usuario.getNombreUsuario();
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.usuario.setNombreUsuario(nombreUsuario);
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
