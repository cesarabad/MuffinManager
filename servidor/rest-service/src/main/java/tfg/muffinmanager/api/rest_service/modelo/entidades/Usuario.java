package tfg.muffinmanager.api.rest_service.modelo.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @Column(name = "dni", length = 9)
    private String dni;
    @Column(name = "nombre", length = 80)
    private String nombre;
    @Column(name = "apellidos", length = 80)
    private String apellidos;
    @Column(name = "nombreusuario", length = 20)
    private String nombreUsuario;
    @Column(name = "contrasenahash",length = 64)
    private String contrasenaHash;

    public Usuario() {
    }

    public Usuario(String dni, String nombre, String apellidos, String nohmreUsuario, String contrasenaHash) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nombreUsuario = nohmreUsuario;
        this.contrasenaHash = contrasenaHash;
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

    public void setNombreUsuario(String nohmreUsuario) {
        this.nombreUsuario = nohmreUsuario;
    }

    public String getContrasenaHash() {
        return contrasenaHash;
    }

    public void setContrasenaHash(String contrasenaHash) {
        this.contrasenaHash = contrasenaHash;
    }
}
