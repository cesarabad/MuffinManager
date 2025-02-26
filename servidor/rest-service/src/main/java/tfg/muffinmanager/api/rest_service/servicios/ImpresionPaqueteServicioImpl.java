package tfg.muffinmanager.api.rest_service.servicios;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfg.muffinmanager.api.rest_service.modelo.entidades.ImpresionPaquete;
import tfg.muffinmanager.api.rest_service.repositorios.ImpresionPaqueteRepositorio;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.ImpresionPaqueteServicio;

@Service
public class ImpresionPaqueteServicioImpl implements ImpresionPaqueteServicio {

    @Autowired
    ImpresionPaqueteRepositorio impresionPaqueteRepositorio;

    @Override
    public ImpresionPaquete guardarImpresionPaquete(ImpresionPaquete impresionPaquete) {
        return impresionPaqueteRepositorio.save(impresionPaquete);
    }

    @Override
    public ImpresionPaquete obtenerPorAbreviatura(String abreviatura) {
        return impresionPaqueteRepositorio.findById(abreviatura).get();
    }

    @Override
    public ArrayList<ImpresionPaquete> obtenerImpresionesPaquete() {
        
        return (ArrayList<ImpresionPaquete>) impresionPaqueteRepositorio.findAll();
    }


}
