package tfg.muffinmanager.api.rest_service.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tfg.muffinmanager.api.rest_service.modelo.entidades.Forma;
@Repository
public interface FormaRepositorio extends CrudRepository<Forma, String> {
    public abstract Forma findByIdForma(String id);

}
