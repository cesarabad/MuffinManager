package tfg.muffinmanager.api.rest_service.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tfg.muffinmanager.api.rest_service.modelo.entidades.Producto;
import tfg.muffinmanager.api.rest_service.modelo.entidades.ids.ProductoId;

@Repository
public interface ProductoRepositorio extends CrudRepository<Producto, ProductoId> {
    public abstract Producto findByReferencia(String referencia);

}
