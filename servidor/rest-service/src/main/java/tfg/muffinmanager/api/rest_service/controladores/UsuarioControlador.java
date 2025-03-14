package tfg.muffinmanager.api.rest_service.controladores;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tfg.muffinmanager.api.rest_service.modelo.dto.UsuarioDTO;
import tfg.muffinmanager.api.rest_service.modelo.entidades.Usuario;
import tfg.muffinmanager.api.rest_service.servicios.UsuarioServicioImpl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {
    @Autowired
    UsuarioServicioImpl usuarioServicio;

    @GetMapping()
    public ArrayList<UsuarioDTO> obtenerUsuarios() {
        return usuarioServicio.obtenerUsuarios();
    }
    
    @PostMapping()
    public UsuarioDTO guardarUsuario(@RequestBody Usuario usuario) {
        return usuarioServicio.guardarUsuario(usuario);
    }

    @GetMapping("/{dni}")
    public UsuarioDTO obtenerPorDni(@PathVariable("dni") String dni) {
        return usuarioServicio.obtenerPorDni(dni);
    }

    @GetMapping("/buscar")
    public ArrayList<UsuarioDTO> obtenerPorNombre(@RequestParam(required = false) String nombre, @RequestParam(required = false) String apellidos, @RequestParam(required = false) String nombreUsuario) {
        
        ArrayList<UsuarioDTO> usuarios = obtenerUsuarios();

        if (nombre != null && !nombre.isEmpty()) {
            usuarios = (ArrayList<UsuarioDTO>) usuarios.stream().filter(usuario -> usuario.getNombre().equalsIgnoreCase(nombre)).collect(Collectors.toList());
        }
        if (apellidos != null && !apellidos.isEmpty()) {
            usuarios = (ArrayList<UsuarioDTO>) usuarios.stream().filter(usuario -> usuario.getApellidos().equalsIgnoreCase(apellidos)).collect(Collectors.toList());
        }
        if (nombreUsuario != null && !nombreUsuario.isEmpty()) {
            usuarios = (ArrayList<UsuarioDTO>) usuarios.stream().filter(usuario -> usuario.getNombreUsuario().equalsIgnoreCase(nombreUsuario)).collect(Collectors.toList());
        }

        return usuarios;
    }

    
    @GetMapping("/autenticacion")
    public UsuarioDTO obtenerPorAutenticacion(@RequestParam String token) {
        return usuarioServicio.obtenerPorAutenticacion(token);
    }
    
    
}
