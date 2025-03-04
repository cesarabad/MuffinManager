package tfg.muffinmanager.api.rest_service.controladores;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tfg.muffinmanager.api.rest_service.modelo.dto.FormaDTO;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.FormaServicio;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/forma")
public class FormaControlador {
 
    @Autowired
    FormaServicio formaServicio;

    @GetMapping()
    public ResponseEntity<ArrayList<FormaDTO>> obtenerFormas() {
        try {
            ArrayList<FormaDTO> formas = formaServicio.obtenerFormasActivas();
            if (formas.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(formas);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<ArrayList<FormaDTO>> obtenerVersionesPorId(@PathVariable String id) {
        try {
            ArrayList<FormaDTO> formas = formaServicio.obtenerVersionesPorId(id);
            if (formas.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(formas);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping("/existe/{id}")
    public ResponseEntity<Boolean> existeForma(@PathVariable String id) {
        try {
            return ResponseEntity.ok(formaServicio.existeForma(id));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping()
    public ResponseEntity<FormaDTO> actualizarForma(@RequestBody FormaDTO forma) {
        try {
            FormaDTO formaActualizada = formaServicio.actualizarForma(forma);
            if (formaActualizada != null) {
                return ResponseEntity.ok(formaActualizada);
            } else {
                return ResponseEntity.badRequest().body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping("/activar")
    public ResponseEntity<Boolean> activarDesactivarForma(@RequestParam String id, @RequestParam int version) {
        try {
            System.out.println("id: " + id + " version: " + version);
            return ResponseEntity.ok(formaServicio.activarDesactivarForma(id, version));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping()
    public ResponseEntity<FormaDTO> guardarForma(@RequestBody FormaDTO forma) {

        try {
            FormaDTO formaGuardada = formaServicio.guardarForma(forma);
            if (formaGuardada != null) {
                return ResponseEntity.ok(formaGuardada);
            } else {
                return ResponseEntity.badRequest().body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
        
    }

    @DeleteMapping()
    public ResponseEntity<Boolean> eliminarForma(@RequestParam boolean delete, @RequestParam String id) {
        try {
            if (delete && id != null) {
                return ResponseEntity.ok(formaServicio.eliminarForma(id));
            } else {
                return ResponseEntity.badRequest().body(null);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
    
}
