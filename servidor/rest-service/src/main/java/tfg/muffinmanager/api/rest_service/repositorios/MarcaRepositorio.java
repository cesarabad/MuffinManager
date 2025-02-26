package tfg.muffinmanager.api.rest_service.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tfg.muffinmanager.api.rest_service.modelo.entidades.Marca;
import tfg.muffinmanager.api.rest_service.modelo.entidades.ids.MarcaId;

@Repository
public interface MarcaRepositorio extends CrudRepository<Marca, MarcaId> {
    public abstract Marca findByIdMarca(String id);
}
