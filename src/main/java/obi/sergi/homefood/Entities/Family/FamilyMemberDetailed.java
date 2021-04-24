package obi.sergi.homefood.Entities.Family;

import obi.sergi.homefood.Entities.User.User;

public class FamilyMemberDetailed {

    private String userId;
    private String firstName;
    private String lastName;
    private String dateAdded;
    private String userRole;

    public FamilyMemberDetailed(User user, String familyMemberSince){
        this.userId = user.getId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.dateAdded = familyMemberSince;
        this.userRole = user.getUserRole();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
