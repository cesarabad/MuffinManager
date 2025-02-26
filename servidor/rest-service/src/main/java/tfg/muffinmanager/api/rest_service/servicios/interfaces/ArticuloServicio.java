package tfg.muffinmanager.api.rest_service.servicios.interfaces;

import java.util.ArrayList;

import tfg.muffinmanager.api.rest_service.modelo.dto.ArticuloDTO;

public interface ArticuloServicio {

    public ArticuloDTO guardarArticulo(ArticuloDTO articuloDTO);
    public ArrayList<ArticuloDTO> obtenerArticulos();
}
