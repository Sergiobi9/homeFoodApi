package obi.sergi.homefood.Entities.Family;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "FAMILY_MEMBER")
public class FamilyMember {

    private String familyId;
    private ArrayList<FamilyMemberRegister> familyMembers;

    public FamilyMember(String familyId){
        this.familyId = familyId;
        familyMembers = new ArrayList<>();
    }

    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    public ArrayList<FamilyMemberRegister> getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(ArrayList<FamilyMemberRegister> familyMembers) {
        this.familyMembers = familyMembers;
    }
}
