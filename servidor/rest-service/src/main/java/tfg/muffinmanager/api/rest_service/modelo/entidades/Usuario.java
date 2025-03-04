package tfg.muffinmanager.api.rest_service.modelo.entidades;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import tfg.muffinmanager.api.rest_service.modelo.dto.UsuarioDTO;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Data
@Entity
@Table(name = "usuario")
@Builder
public class Usuario implements UserDetails {
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
    @ManyToMany
    @JoinTable(name = "usuario_grupo",
            joinColumns = @JoinColumn(name = "usuario"),
            inverseJoinColumns = @JoinColumn(name = "grupo"))
    private Set<GrupoPermisos> gruposPermisos;
    @ManyToMany
    @JoinTable(name = "permiso_usuario",
            joinColumns = @JoinColumn(name = "usuario"),
            inverseJoinColumns = @JoinColumn(name = "permiso"))
    private Set<Permiso> permisos;

    public Usuario() {
    }

    public Usuario(String dni, String nombre, String apellidos, String nombreUsuario, String contrasenaHash,
            Set<GrupoPermisos> gruposPermisos, Set<Permiso> permisos) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nombreUsuario = nombreUsuario;
        this.contrasenaHash = contrasenaHash;
        this.gruposPermisos = gruposPermisos;
        this.permisos = permisos;
    }

    public UsuarioDTO toDTO() {
        return new UsuarioDTO(this.dni, this.nombre, this.apellidos, this.nombreUsuario , this.gruposPermisos, this.permisos);
    }
    
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Stream.concat(
                    permisos.stream().map(permiso -> new SimpleGrantedAuthority("ROLE_" + permiso.getNombre())), 
                    gruposPermisos.stream()
                                .flatMap(grupo -> grupo.getPermisos().stream())
                                .map(permiso -> new SimpleGrantedAuthority("ROLE_" + permiso.getNombre()))
            )
            .collect(Collectors.toSet()); // Usamos Set para evitar duplicados
    }
    @Override
    public String toString() {
        return "Usuario [apellidos=" + apellidos + ", contrasenaHash=" + contrasenaHash + ", dni=" + dni
                + ", gruposPermisos=" + gruposPermisos + ", nombre=" + nombre + ", nombreUsuario=" + nombreUsuario
                + ", permisos=" + permisos + "]";
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    @Override
    public String getPassword() {
        return contrasenaHash;
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

    @Override
    public String getUsername() {
        return nombreUsuario;
    }

   
}
