package obi.sergi.homefood.Controllers.Role;

import obi.sergi.homefood.Entities.Role.Role;
import obi.sergi.homefood.Repositories.Role.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/register")
    public ResponseEntity registerRole(@RequestBody Role role) {
        roleRepository.save(role);
        return new ResponseEntity(role, HttpStatus.valueOf(200));
    }
}
