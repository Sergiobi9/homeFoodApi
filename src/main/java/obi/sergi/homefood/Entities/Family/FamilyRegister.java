package obi.sergi.homefood.Entities.Family;

import java.util.ArrayList;

public class FamilyRegister {

    private Family family;
    private ArrayList<String> membersUserIds;

    public FamilyRegister(){}

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public ArrayList<String> getMembersUserIds() {
        return membersUserIds;
    }

    public void setMembersUserIds(ArrayList<String> membersUserIds) {
        this.membersUserIds = membersUserIds;
    }
}
