package obi.sergi.homefood.Controllers.Family;

import obi.sergi.homefood.Entities.Family.FamilyMember;
import obi.sergi.homefood.Entities.Family.FamilyMemberDetailed;
import obi.sergi.homefood.Entities.Family.FamilyMemberRegister;
import obi.sergi.homefood.Entities.Family.FamilyRegister;
import obi.sergi.homefood.Entities.User.User;
import obi.sergi.homefood.Repositories.Family.FamilyMemberRepository;
import obi.sergi.homefood.Repositories.User.UserRepository;
import obi.sergi.homefood.Utils.DateFormater;
import obi.sergi.homefood.Utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/family/members")
public class FamilyMemberController {

    @Autowired
    private FamilyMemberRepository familyMemberRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/familyId/{familyId}")
    public ResponseEntity getFamilyMembers(@PathVariable String familyId) {
        FamilyMember familyMember = familyMemberRepository.findFamilyMemberByFamilyId(familyId);

        ArrayList<FamilyMemberDetailed> familyMembersDetailed = new ArrayList<>();
        ArrayList<FamilyMemberRegister> familyMembers = familyMember.getFamilyMembers();

        for (FamilyMemberRegister familyMemberRegister : familyMembers){
            String userId = familyMemberRegister.getUserId();
            String familyMemberSince = familyMemberRegister.getDateRegistered();

            User user = userRepository.findUserById(userId);

            if (user != null){
                String familyMemberSinceFormated = DateFormater.getDateWithFormat(DateFormater.getDateAsCalendar(familyMemberSince));
                FamilyMemberDetailed familyMemberDetailed = new FamilyMemberDetailed(user, familyMemberSinceFormated);
                familyMembersDetailed.add(familyMemberDetailed);
            }
        }

        return new ResponseEntity(familyMembersDetailed, HttpStatus.valueOf(200));
    }
}
