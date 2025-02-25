package tfg.muffinmanager.api.rest_service.servicios;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfg.muffinmanager.api.rest_service.modelo.entidades.Caja;
import tfg.muffinmanager.api.rest_service.repositorios.CajaRepositorio;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.CajaServicio;

@Service
public class CajaServicioImpl implements CajaServicio {

    @Autowired
    CajaRepositorio cajaRepositorio;

    @Override
    public Caja guardarCaja(Caja caja) {
        return cajaRepositorio.save(caja);
    }

    @Override
    public ArrayList<Caja> obtenerCajas() {
        
        return (ArrayList<Caja>) cajaRepositorio.findAll();
    }

    @Override
    public Caja actualizarCaja(Caja caja) {
        return null;
    }

    @Override
    public Caja obtenerPorEnv(String env) {
        return null;
    }

    @Override
    public boolean existeCaja(String env) {
        return false;
    }

    @Override
    public boolean eliminarPorEnv(String env) {
        return false;
    }

}
