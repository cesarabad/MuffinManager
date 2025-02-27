package tfg.muffinmanager.api.rest_service.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tfg.muffinmanager.api.rest_service.modelo.entidades.Caja;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.CajaServicio;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/caja")
public class CajaControlador {
    @Autowired
    CajaServicio cajaServicio;

    @GetMapping()
    public ResponseEntity<ArrayList<Caja>> obtenerCajas() {
        try{
            ArrayList<Caja> cajas = cajaServicio.obtenerCajas();
            if (cajas.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(cajas);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
    
    @PostMapping()
    public ResponseEntity<Caja> guardarCaja(@RequestBody Caja caja) {
        try{
            Caja cajaGuardada = cajaServicio.guardarCaja(caja);
            if(cajaGuardada != null) {
                return ResponseEntity.ok(cajaGuardada);
            } else {
                return ResponseEntity.badRequest().body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
    


    @PutMapping()
    public ResponseEntity<Caja> actualizarCaja(@RequestBody Caja caja) {
        try{
            Caja cajaActualizada = cajaServicio.actualizarCaja(caja);
            if (cajaActualizada != null) {
                return ResponseEntity.ok(cajaActualizada);
            } else {
                return ResponseEntity.badRequest().body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @DeleteMapping()
    public boolean eliminarPorEnv(@RequestParam boolean delete, @RequestParam String env) {
        return cajaServicio.eliminarPorEnv(env);
    }
    
}
