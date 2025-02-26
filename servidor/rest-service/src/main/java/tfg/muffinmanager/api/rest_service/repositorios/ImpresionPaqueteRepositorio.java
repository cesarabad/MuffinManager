package tfg.muffinmanager.api.rest_service.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tfg.muffinmanager.api.rest_service.modelo.entidades.ImpresionPaquete;

@Repository
public interface ImpresionPaqueteRepositorio extends CrudRepository<ImpresionPaquete, String> { 

    public abstract ImpresionPaquete findByAbreviatura(String abreviatura);
}
