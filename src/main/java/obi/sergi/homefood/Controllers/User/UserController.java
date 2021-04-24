package obi.sergi.homefood.Controllers.User;

import obi.sergi.homefood.Entities.Role.Role;
import obi.sergi.homefood.Entities.User.User;
import obi.sergi.homefood.Repositories.Role.RoleRepository;
import obi.sergi.homefood.Repositories.User.UserRepository;
import obi.sergi.homefood.Security.JwtTokenProvider;
import obi.sergi.homefood.Utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody User user) {
        Map<Object, Object> model = new HashMap<>();

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        saveUserWithRole(user, Constants.USER_ROLE);

        String userEmail = user.getEmail();
        String token = jwtTokenProvider.createToken(userEmail, user.getRoles());
        model.put("user", user);
        model.put("token", token);

        return new ResponseEntity(model, HttpStatus.valueOf(200));
    }

    private void saveUserWithRole(User user, String role) {
        Role userRole = roleRepository.findByRole(role);
        user.setRoles(new HashSet<>(Collections.singletonList(userRole)));
        user.setUserRole(role);
        userRepository.save(user);
    }
}
