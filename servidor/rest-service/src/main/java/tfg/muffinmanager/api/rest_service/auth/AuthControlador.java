package tfg.muffinmanager.api.rest_service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tfg.muffinmanager.api.rest_service.servicios.interfaces.AuthServicio;

@RestController
@RequestMapping("/auth")
public class AuthControlador {

    @Autowired
    private AuthServicio authServicio;


    @GetMapping()
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("Auth API");
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authServicio.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authServicio.register(request));
    }
}
