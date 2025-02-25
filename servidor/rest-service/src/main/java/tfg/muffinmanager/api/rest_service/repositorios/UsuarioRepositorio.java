package tfg.muffinmanager.api.rest_service.repositorios;

import org.springframework.data.repository.CrudRepository;

import tfg.muffinmanager.api.rest_service.modelo.entidades.Usuario;

public interface UsuarioRepositorio extends CrudRepository<Usuario, String> {

}
