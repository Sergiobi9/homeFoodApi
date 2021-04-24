package obi.sergi.homefood.Entities.Family;

public class FamilyMemberRegister {

    private String userId;
    private String dateRegistered;

    public FamilyMemberRegister(String userId, String dateRegistered){
        this.userId = userId;
        this.dateRegistered = dateRegistered;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(String dateRegistered) {
        this.dateRegistered = dateRegistered;
    }
}
