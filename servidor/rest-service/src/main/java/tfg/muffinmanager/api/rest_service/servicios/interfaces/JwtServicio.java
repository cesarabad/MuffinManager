package tfg.muffinmanager.api.rest_service.servicios.interfaces;

import org.springframework.security.core.userdetails.UserDetails;


public interface JwtServicio {
    public String getToken(UserDetails usuario);

    public String getUsernameFromToken(String token);

    public boolean isTokenValid(String token, UserDetails userDetails);
}
