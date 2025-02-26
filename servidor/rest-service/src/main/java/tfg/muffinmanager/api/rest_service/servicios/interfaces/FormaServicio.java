package tfg.muffinmanager.api.rest_service.servicios.interfaces;

import java.util.ArrayList;


import tfg.muffinmanager.api.rest_service.modelo.dto.FormaDTO;
import tfg.muffinmanager.api.rest_service.modelo.entidades.Forma;


public interface FormaServicio {
    public FormaDTO guardarForma(FormaDTO formaDTO);
    public ArrayList<FormaDTO> obtenerFormas();
    public Forma obtenerPorId(String id);
}
