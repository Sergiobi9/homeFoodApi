package obi.sergi.homefood.Controllers.Authentication;

import obi.sergi.homefood.Entities.Authentication.AuthenticationData;
import obi.sergi.homefood.Entities.User.User;
import obi.sergi.homefood.Repositories.User.UserRepository;
import obi.sergi.homefood.Security.JwtTokenProvider;
import obi.sergi.homefood.Utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import static obi.sergi.homefood.Utils.Response.USER_DO_NOT_EXIST;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationData authenticationData) {
        Map<Object, Object> model = new HashMap<>();

        String userEmail = authenticationData.getEmail();
        String password = authenticationData.getPassword();

        User user = userRepository.findUserByEmail(userEmail);

        if (user == null) {
            model.put(Response.INFO, USER_DO_NOT_EXIST);
        } else {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userEmail, password));
            String token = jwtTokenProvider.createToken(userEmail, user.getRoles());
            model.put("user", user);
            model.put("token", token);
        }

        return new ResponseEntity(model, HttpStatus.valueOf(200));
    }
}
