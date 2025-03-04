package tfg.muffinmanager.api.rest_service.servicios.interfaces;

import java.util.ArrayList;

import tfg.muffinmanager.api.rest_service.modelo.dto.UsuarioDTO;
import tfg.muffinmanager.api.rest_service.modelo.entidades.Usuario;

public interface UsuarioServicio {

    public UsuarioDTO guardarUsuario(Usuario usuario);
    public ArrayList<UsuarioDTO> obtenerUsuarios();
    public UsuarioDTO obtenerPorNombreUsuario(String nombreUsuario);
    public boolean existeUsuario(String dni);
    public UsuarioDTO obtenerPorAutenticacion(String token);
    public UsuarioDTO obtenerPorDni(String dni);
    public Usuario obtenerEntidadPorDni(String dni);
}
