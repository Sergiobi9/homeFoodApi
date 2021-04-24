package obi.sergi.homefood.Controllers.Family;

import obi.sergi.homefood.Entities.Family.Family;
import obi.sergi.homefood.Entities.Family.FamilyMember;
import obi.sergi.homefood.Entities.Family.FamilyRegister;
import obi.sergi.homefood.Entities.Role.Role;
import obi.sergi.homefood.Entities.User.User;
import obi.sergi.homefood.Repositories.Family.FamilyMemberRepository;
import obi.sergi.homefood.Repositories.Family.FamilyRepository;
import obi.sergi.homefood.Repositories.Role.RoleRepository;
import obi.sergi.homefood.Repositories.User.UserRepository;
import obi.sergi.homefood.Utils.Constants;
import obi.sergi.homefood.Utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/family")
public class FamilyController {

    @Autowired
    private FamilyRepository familyRepository;

    @Autowired
    private FamilyMemberRepository familyMemberRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping("/register")
    public ResponseEntity registerFamily(@RequestBody FamilyRegister familyRegister) {
        Map<Object, Object> model = new HashMap<>();

        /* Register family */
        Family family = familyRegister.getFamily();
        familyRepository.insert(family);

        /* Register family members */
        ArrayList<String> familyMembers = familyRegister.getMembersEmails();
        String familyId = family.getOwnerId();
        String familyOwnerId = family.getOwnerId();

        FamilyMember familyMember = new FamilyMember(familyId);
        ArrayList<String> familyMemberUserIds = familyMember.getUserIds();
        familyMemberUserIds.add(familyOwnerId);

        /* Add family members */
        for (String email : familyMembers){
            User user = userRepository.findUserByEmail(email);

            if (user != null){
                String userId = user.getId();
                familyMemberUserIds.add(userId);
            }
        }

        /* Register family member */
        familyMemberRepository.insert(familyMember);

        model.put(Response.INFO, Response.SUCCESS);
        return new ResponseEntity(model, HttpStatus.valueOf(200));
    }

    private User saveUserWithFamilyMemberRole(User user) {
        Role userRole = roleRepository.findByRole(Constants.USER_ROLE);
        user.setRoles(new HashSet<>(Collections.singletonList(userRole)));
        user.setUserRole(Constants.USER_ROLE);
        userRepository.save(user);
        return user;
    }

    private User saveUserWithFamilyOwnerRole(User user) {
        Role userRole = roleRepository.findByRole(Constants.USER_ROLE);
        user.setRoles(new HashSet<>(Collections.singletonList(userRole)));
        user.setUserRole(Constants.USER_ROLE);
        userRepository.save(user);
        return user;
    }
}
