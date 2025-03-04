package tfg.muffinmanager.api.rest_service.servicios.interfaces;

import java.util.ArrayList;


import tfg.muffinmanager.api.rest_service.modelo.dto.FormaDTO;


public interface FormaServicio {
    public FormaDTO guardarForma(FormaDTO formaDTO);
    public ArrayList<FormaDTO> obtenerFormasActivas();
    public ArrayList<FormaDTO> obtenerVersionesPorId(String id);
    public FormaDTO actualizarForma(FormaDTO formaDTO);
    public boolean existeForma(String id);
    public boolean eliminarForma(String id);
    public boolean activarDesactivarForma(String id, int version);
}
