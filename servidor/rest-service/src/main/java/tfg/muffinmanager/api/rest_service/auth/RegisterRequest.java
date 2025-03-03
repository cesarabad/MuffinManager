package tfg.muffinmanager.api.rest_service.auth;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tfg.muffinmanager.api.rest_service.modelo.entidades.GrupoPermisos;
import tfg.muffinmanager.api.rest_service.modelo.entidades.Permiso;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    private String nombreUsuario;
    private String contrasena;
    private String nombre;
    private String apellidos;
    private String dni;
    private Set<Permiso> permisos;
    private Set<GrupoPermisos> gruposPermisos;
}
