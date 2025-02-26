package tfg.muffinmanager.api.rest_service.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tfg.muffinmanager.api.rest_service.modelo.entidades.Articulo;

@Repository
public interface ArticuloRepositorio extends CrudRepository<Articulo, String> {
    public abstract Articulo findByReferencia(String referencia);

}
