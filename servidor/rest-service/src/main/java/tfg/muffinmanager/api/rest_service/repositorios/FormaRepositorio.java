package tfg.muffinmanager.api.rest_service.repositorios;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tfg.muffinmanager.api.rest_service.modelo.entidades.Forma;
import tfg.muffinmanager.api.rest_service.modelo.entidades.ids.FormaId;
@Repository
public interface FormaRepositorio extends CrudRepository<Forma, FormaId> {
    public abstract ArrayList<Forma> findByIdForma(String id);
    public abstract boolean existsByIdForma(String id);
}
