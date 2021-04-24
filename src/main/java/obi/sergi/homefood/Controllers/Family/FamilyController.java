package obi.sergi.homefood.Controllers.Family;

import obi.sergi.homefood.Entities.Family.Family;
import obi.sergi.homefood.Entities.Family.FamilyMember;
import obi.sergi.homefood.Entities.Family.FamilyMemberRegister;
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

    @PostMapping("/register/{currentDate}")
    public ResponseEntity registerFamily(@PathVariable String currentDate, @RequestBody FamilyRegister familyRegister) {
        Map<Object, Object> model = new HashMap<>();

        /* Register family */
        Family family = familyRegister.getFamily();
        familyRepository.insert(family);
        String familyOwnerId = family.getOwnerId();
        User ownerUser = userRepository.findUserById(familyOwnerId);
        saveUserWithFamilyOwnerRole(ownerUser);

        /* Register family members */
        ArrayList<FamilyMemberRegister> familyMembers = familyRegister.getMembersUsers();
        String familyId = family.getId();
        FamilyMember familyMember = new FamilyMember(familyId);
        ArrayList<FamilyMemberRegister> familyMemberUserIds = familyMember.getFamilyMembers();
        familyMemberUserIds.add(new FamilyMemberRegister(familyOwnerId, currentDate));

        /* Add family members */
        for (FamilyMemberRegister member : familyMembers){
            String userId = member.getUserId();
            User user = userRepository.findUserById(userId);

            if (user != null){
                familyMemberUserIds.add(new FamilyMemberRegister(userId, currentDate));
                saveUserWithFamilyMemberRole(user);
            }
        }

        /* Register family member */
        familyMemberRepository.insert(familyMember);

        model.put(Response.INFO, Response.SUCCESS);
        return new ResponseEntity(model, HttpStatus.valueOf(200));
    }

    private User saveUserWithFamilyMemberRole(User user) {
        Role userRole = roleRepository.findByRole(Constants.FAMILY_MEMBER_ROLE);
        user.setRoles(new HashSet<>(Collections.singletonList(userRole)));
        user.setUserRole(Constants.FAMILY_MEMBER_ROLE);
        userRepository.save(user);
        return user;
    }

    private User saveUserWithFamilyOwnerRole(User user) {
        Role userRole = roleRepository.findByRole(Constants.FAMILY_OWNER_ROLE);
        user.setRoles(new HashSet<>(Collections.singletonList(userRole)));
        user.setUserRole(Constants.FAMILY_OWNER_ROLE);
        userRepository.save(user);
        return user;
    }
}
