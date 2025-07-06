package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.client.HttpClientAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
public class AuthController<S> {
    @Autowired
    private AuthenticationManager authManage;
    @Autowired
    private CustomUserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    private String jwt;

    @PostMapping ( "/register" )
    public ResponseEntity<String> register(@RequestBody User user) {
        if (userRepo.findByemail(user.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email already registerd.");


        }
        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
     //   S save = userRepo.save("USER");
        return ResponseEntity.ok("User registerd sucessfully.");
    }

    @PostMapping ( "/login" )
    public <AuthRequest> ResponseEntity<String> login(@RequestBody AuthRequest request) throws Exception {
        //Authentication authenticate = authManage.authenticate(new UsernamePasswordAuthenticationToken(request.getClass(), request.getClass()));
     //   final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getemail());

        return ResponseEntity.ok(jwt);
    }


    private class CustomUserDetailsService {
    }

    private class JwtUtil {
    }
}