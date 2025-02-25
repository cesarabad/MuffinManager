package tfg.muffinmanager.api.rest_service.servicios;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfg.muffinmanager.api.rest_service.modelo.dto.UsuarioContrasenaDTO;
import tfg.muffinmanager.api.rest_service.modelo.dto.UsuarioDTO;
import tfg.muffinmanager.api.rest_service.modelo.entidades.Usuario;
import tfg.muffinmanager.api.rest_service.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServicio {
    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    public ArrayList<UsuarioDTO> obtenerUsuarios() {
        ArrayList<UsuarioDTO> usuarios = new ArrayList<>();
        usuarioRepositorio.findAll().forEach(usuario -> usuarios.add(new UsuarioDTO(usuario.getDni(), usuario.getNombre(), usuario.getApellidos(), usuario.getNombreUsuario())));
        return usuarios;
    }

    public UsuarioDTO guardarUsuario(UsuarioDTO usuario, String contrasena) {
        usuarioRepositorio.save(new Usuario(usuario.getDni(), usuario.getNombre(), usuario.getApellidos(), usuario.getNombreUsuario(), contrasena));
        return usuario;
    }
}
