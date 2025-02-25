package tfg.muffinmanager.api.rest_service.servicios.interfaces;

import java.util.ArrayList;

import tfg.muffinmanager.api.rest_service.modelo.dto.UsuarioDTO;
import tfg.muffinmanager.api.rest_service.modelo.entidades.Usuario;

public interface UsuarioServicio {

    public UsuarioDTO guardarUsuario(Usuario usuario);
    public ArrayList<UsuarioDTO> obtenerUsuarios();
    public UsuarioDTO actualizarUsuario(Usuario usuario);
    public UsuarioDTO obtenerPorDni(String dni);
    public boolean existeUsuario(String dni);
    public boolean eliminarPorDni(String dni);
    public Usuario dtoToUsuario(UsuarioDTO usuarioDTO);
}
