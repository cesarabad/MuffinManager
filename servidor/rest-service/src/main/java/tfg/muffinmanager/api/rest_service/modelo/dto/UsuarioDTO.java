package tfg.muffinmanager.api.rest_service.modelo.dto;

public class UsuarioDTO {

    private String dni;
    private String nombre;
    private String apellidos;
    private String nombreUsuario;

    public UsuarioDTO() {
    }
    public UsuarioDTO(String dni, String nombre, String apellidos, String nombreUsuario) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nombreUsuario = nombreUsuario;
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
}
