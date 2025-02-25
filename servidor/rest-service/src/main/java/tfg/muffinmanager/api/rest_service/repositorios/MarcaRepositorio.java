package tfg.muffinmanager.api.rest_service.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tfg.muffinmanager.api.rest_service.modelo.entidades.Marca;

@Repository
public interface MarcaRepositorio extends CrudRepository<Marca, String> {
    public abstract Marca findByIdMarca(String id);
}
