package tfg.muffinmanager.api.rest_service.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tfg.muffinmanager.api.rest_service.modelo.entidades.MovimientoStock;
import tfg.muffinmanager.api.rest_service.modelo.entidades.ids.MovimientoStockId;

@Repository
public interface MovimientoStockRepositorio extends CrudRepository<MovimientoStock, MovimientoStockId> {


}
