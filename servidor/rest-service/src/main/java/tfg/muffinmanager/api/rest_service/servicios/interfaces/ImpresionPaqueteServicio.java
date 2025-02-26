package tfg.muffinmanager.api.rest_service.servicios.interfaces;

import java.util.ArrayList;

import tfg.muffinmanager.api.rest_service.modelo.entidades.ImpresionPaquete;

public interface ImpresionPaqueteServicio {
    public ImpresionPaquete guardarImpresionPaquete(ImpresionPaquete impresionPaquete);
    public ImpresionPaquete obtenerPorAbreviatura(String abreviatura);
    public ArrayList<ImpresionPaquete> obtenerImpresionesPaquete();
}
