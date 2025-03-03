package tfg.muffinmanager.api.rest_service.jwt;

import java.security.Key;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import tfg.muffinmanager.api.rest_service.servicios.interfaces.JwtServicio;

@Service
public class JwtServicioImpl implements JwtServicio {

    private static final String SECRET_KEY = "rF7dh9Kz+YqP3w2XJbM6tVpQzN8gLfAa2RsXYoZ0QcE=";


    @Override
    public String getToken(UserDetails usuario) {
        return getToken(new HashMap<>(), usuario);
    }

    private String getToken(Map<String, Object> claims, UserDetails usuario) {
        return Jwts
            .builder()
            .setClaims(claims)
            .setSubject(usuario.getUsername())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis()+1000*60*24*1))
            .signWith(getKey(), SignatureAlgorithm.HS256)
            .compact();
    }
            
    private Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    @Override
    public String getUsernameFromToken(String token) {
        return getClaim(token, Claims::getSubject);
    }

    @Override
    public boolean isTokenValid(String token, UserDetails userDetails) {
        String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private Claims getAllClaims(String token) {
        return Jwts
            .parserBuilder()
            .setSigningKey(getKey())
            .build()
            .parseClaimsJws(token)
            .getBody();
    }

    public <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Date getExpiration(String token) {
        return getClaim(token, Claims::getExpiration);
    }

    private boolean isTokenExpired(String token) {
        return getExpiration(token).before(new Date());
    }
}
