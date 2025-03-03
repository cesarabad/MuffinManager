package tfg.muffinmanager.api.rest_service.servicios.interfaces;

import tfg.muffinmanager.api.rest_service.auth.AuthResponse;
import tfg.muffinmanager.api.rest_service.auth.LoginRequest;
import tfg.muffinmanager.api.rest_service.auth.RegisterRequest;

public interface AuthServicio {
    public AuthResponse login(LoginRequest request);
    public AuthResponse register(RegisterRequest request);
}
