package security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import model.Usuario;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public AuthService(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public String login(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );

        Usuario usuario = (Usuario) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(usuario.getUsername())
                .claim("id", usuario.getId())
                .claim("nome", usuario.getNome())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 60 minutos
                .signWith(key)
                .compact();
    }

    public Key getKey() {
        return key;
    }
}