package tfg.muffinmanager.api.rest_service.servicios.interfaces;

import java.util.ArrayList;

import tfg.muffinmanager.api.rest_service.modelo.dto.MarcaDTO;

public interface MarcaServicio {
    public MarcaDTO guardarMarca(MarcaDTO marcaDTO);
    public ArrayList<MarcaDTO> obtenerMarcas();
}
