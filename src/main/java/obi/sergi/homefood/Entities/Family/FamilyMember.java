package obi.sergi.homefood.Entities.Family;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "FAMILY_MEMBER")
public class FamilyMember {

    private String familyId;
    private ArrayList<String> userIds;

    public FamilyMember(String familyId){
        this.familyId = familyId;
        userIds = new ArrayList<>();
    }

    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    public ArrayList<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(ArrayList<String> userIds) {
        this.userIds = userIds;
    }
}
