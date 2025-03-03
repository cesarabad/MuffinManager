package tfg.muffinmanager.api.rest_service.repositorios;


import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import tfg.muffinmanager.api.rest_service.modelo.entidades.Usuario;

public interface UsuarioRepositorio extends CrudRepository<Usuario, String> {
    public abstract Usuario findByDni(String dni);
    @EntityGraph(attributePaths = {"gruposPermisos.permisos", "permisos"})
    public abstract Optional<Usuario> findByNombreUsuario(String nombreUsuario);
}
