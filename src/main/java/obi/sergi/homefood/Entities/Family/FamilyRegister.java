package obi.sergi.homefood.Entities.Family;

import java.util.ArrayList;

public class FamilyRegister {

    private Family family;
    private ArrayList<FamilyMemberRegister> membersUsers;

    public FamilyRegister(){}

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public ArrayList<FamilyMemberRegister> getMembersUsers() {
        return membersUsers;
    }

    public void setMembersUsers(ArrayList<FamilyMemberRegister> membersUsers) {
        this.membersUsers = membersUsers;
    }
}
