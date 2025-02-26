package tfg.muffinmanager.api.rest_service.servicios.interfaces;

import java.util.ArrayList;

import tfg.muffinmanager.api.rest_service.modelo.dto.ArticuloDTO;
import tfg.muffinmanager.api.rest_service.modelo.entidades.Articulo;

public interface ArticuloServicio {

    public ArticuloDTO guardarArticulo(ArticuloDTO articuloDTO);
    public ArrayList<ArticuloDTO> obtenerArticulos();
    public Articulo obtenerPorId(String id);
}
