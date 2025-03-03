package tfg.muffinmanager.api.rest_service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tfg.muffinmanager.api.rest_service.modelo.entidades.Usuario;
import tfg.muffinmanager.api.rest_service.repositorios.UsuarioRepositorio;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.AuthServicio;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.JwtServicio;

@Service
public class AuthServicioImpl implements AuthServicio{

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private JwtServicio jwtServicio;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public AuthResponse login(LoginRequest request) {
        
        
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        
        UserDetails user = usuarioRepositorio.findByNombreUsuario(request.getUsername()).orElseThrow();
        
            
        String token = jwtServicio.getToken(user);
        return AuthResponse.builder()
            .token(token)
            .build();
    }

    @Override
    public AuthResponse register(RegisterRequest request) {
        Usuario usuario = Usuario.builder()
            .nombreUsuario(request.getNombreUsuario())
            .contrasenaHash(passwordEncoder.encode(request.getContrasena()))
            .nombre(request.getNombre())
            .apellidos(request.getApellidos())
            .dni(request.getDni())
            .permisos(request.getPermisos())
            .gruposPermisos(request.getGruposPermisos())
            .build();

        usuarioRepositorio.save(usuario);

        return AuthResponse.builder()
            .token(jwtServicio.getToken(usuario))
            .build();
    }

}
