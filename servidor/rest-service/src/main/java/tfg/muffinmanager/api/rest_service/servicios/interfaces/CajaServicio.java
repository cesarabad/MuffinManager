package tfg.muffinmanager.api.rest_service.servicios.interfaces;

import java.util.ArrayList;

import tfg.muffinmanager.api.rest_service.modelo.entidades.Caja;


public interface CajaServicio {

    public Caja guardarCaja(Caja caja);
    public ArrayList<Caja> obtenerCajas();
    public Caja actualizarCaja(Caja caja);
    public boolean eliminarPorEnv(String env);
}
