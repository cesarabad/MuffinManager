package tfg.muffinmanager.api.rest_service.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tfg.muffinmanager.api.rest_service.modelo.entidades.Caja;

@Repository
public interface CajaRepositorio extends CrudRepository<Caja, String> {
    public abstract Caja findByEnv(String env);
}
