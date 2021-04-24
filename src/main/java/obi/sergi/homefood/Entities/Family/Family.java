package obi.sergi.homefood.Entities.Family;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "FAMILY")
public class Family {

    private String id;
    private String name;
    private String ownerId;
    private String dateRegistered;

    public Family(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getDateRegistered() {
        return dateRegistered;
    }

    public void setDateRegistered(String dateRegistered) {
        this.dateRegistered = dateRegistered;
    }
}
