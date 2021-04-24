package obi.sergi.homefood.Entities.Family;

import java.util.ArrayList;

public class FamilyRegister {

    private Family family;
    private ArrayList<String> membersEmails;

    public FamilyRegister(){}

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public ArrayList<String> getMembersEmails() {
        return membersEmails;
    }

    public void setMembersEmails(ArrayList<String> membersEmails) {
        this.membersEmails = membersEmails;
    }
}
