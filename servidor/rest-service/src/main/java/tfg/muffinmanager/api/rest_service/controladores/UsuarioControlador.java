package tfg.muffinmanager.api.rest_service.controladores;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tfg.muffinmanager.api.rest_service.modelo.dto.UsuarioContrasenaDTO;
import tfg.muffinmanager.api.rest_service.modelo.dto.UsuarioDTO;
import tfg.muffinmanager.api.rest_service.modelo.entidades.Usuario;
import tfg.muffinmanager.api.rest_service.servicios.UsuarioServicio;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {
    @Autowired
    UsuarioServicio usuarioServicio;

    @GetMapping()
    public ArrayList<UsuarioDTO> obtenerUsuarios() {
        return usuarioServicio.obtenerUsuarios();
    }
    
    @PostMapping()
    public UsuarioDTO guardarUsuario(@RequestBody UsuarioContrasenaDTO usuario) {
        return usuarioServicio.guardarUsuario(usuario.getUsuario(), usuario.getContrasena());
    }
    
}
