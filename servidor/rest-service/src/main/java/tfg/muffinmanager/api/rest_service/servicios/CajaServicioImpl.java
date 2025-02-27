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
        if (cajaRepositorio.existsById(caja.getEnv())) {
            return null;
        }
        return cajaRepositorio.save(caja);
    }

    @Override
    public ArrayList<Caja> obtenerCajas() {
        
        return (ArrayList<Caja>) cajaRepositorio.findAll();
    }

    @Override
    public Caja actualizarCaja(Caja caja) {
        if (!cajaRepositorio.existsById(caja.getEnv())) {
            return null;
        }
        return cajaRepositorio.save(caja);
    }

    

    @Override
    public boolean eliminarPorEnv(String env) {
        cajaRepositorio.deleteById(env);
        return !cajaRepositorio.existsById(env);
    }

    

}
