package tfg.muffinmanager.api.rest_service.servicios;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tfg.muffinmanager.api.rest_service.modelo.dto.UsuarioDTO;
import tfg.muffinmanager.api.rest_service.modelo.entidades.Usuario;
import tfg.muffinmanager.api.rest_service.repositorios.UsuarioRepositorio;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.UsuarioServicio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {
    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    @Override
    public ArrayList<UsuarioDTO> obtenerUsuarios() {
        ArrayList<UsuarioDTO> usuarios = new ArrayList<>();
        usuarioRepositorio.findAll().forEach(usuario -> usuarios.add(new UsuarioDTO(usuario.getDni(), usuario.getNombre(), usuario.getApellidos(), usuario.getNombreUsuario(), usuario.getGruposPermisos(), usuario.getPermisos())));
        return usuarios;
    }
    @Override
    public UsuarioDTO guardarUsuario(Usuario usuario) {

        if (existeUsuario(usuario.getDni())) {
            return null;
        }
        usuarioRepositorio.save(usuario);
        return usuario.toDTO();
    }
    @Override
    public UsuarioDTO actualizarUsuario(Usuario usuario) {
        if (!existeUsuario(usuario.getDni())) {
            return null;
        }
        usuarioRepositorio.save(usuario);
        return usuario.toDTO();
    }
    @Override
    public Usuario dtoToUsuario(UsuarioDTO usuarioDTO) {
        return usuarioRepositorio.findByDni(usuarioDTO.getDni());
    }
    @Override
    public UsuarioDTO obtenerPorDni(String dni) {
        return usuarioRepositorio.findByDni(dni).toDTO();
    }

    @Override
    public boolean existeUsuario(String dni) {
        return usuarioRepositorio.findByDni(dni) != null;
    }

    @Override
    public boolean eliminarPorDni(String dni) {
        try {
            usuarioRepositorio.delete(usuarioRepositorio.findByDni(dni));
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }
}
