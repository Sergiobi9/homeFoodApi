package obi.sergi.homefood.Controllers.Family;

import obi.sergi.homefood.Entities.Family.*;
import obi.sergi.homefood.Entities.User.User;
import obi.sergi.homefood.Repositories.Family.FamilyMemberRepository;
import obi.sergi.homefood.Repositories.Family.FamilyRepository;
import obi.sergi.homefood.Repositories.User.UserRepository;
import obi.sergi.homefood.Utils.DateFormater;
import obi.sergi.homefood.Utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/family/members")
public class FamilyMemberController {

    @Autowired
    private FamilyMemberRepository familyMemberRepository;

    @Autowired
    private FamilyRepository familyRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/userId/{userId}")
    public ResponseEntity getFamilyMembers(@PathVariable String userId) {
        Map<Object, Object> model = new HashMap<>();

        FamilyMember familyMember = familyMemberRepository.findByUserId(userId);

        ArrayList<FamilyMemberDetailed> familyMembersDetailed = new ArrayList<>();
        ArrayList<FamilyMemberRegister> familyMembers = familyMember.getFamilyMembers();

        for (FamilyMemberRegister familyMemberRegister : familyMembers){
            String familyMemberUserId = familyMemberRegister.getUserId();
            String familyMemberSince = familyMemberRegister.getDateRegistered();

            User user = userRepository.findUserById(familyMemberUserId);

            if (user != null){
                String familyMemberSinceFormated = DateFormater.getDateWithFormat(DateFormater.getDateAsCalendar(familyMemberSince));
                FamilyMemberDetailed familyMemberDetailed = new FamilyMemberDetailed(user, familyMemberSinceFormated);
                familyMembersDetailed.add(familyMemberDetailed);
            }
        }

        String familyId = familyMember.getFamilyId();
        Family family = familyRepository.findFamilyById(familyId);

        model.put("familyId", family.getId());
        model.put("familyName", family.getName());
        model.put("familyMembersDetailed",familyMembersDetailed);

        return new ResponseEntity(model, HttpStatus.valueOf(200));
    }
}
