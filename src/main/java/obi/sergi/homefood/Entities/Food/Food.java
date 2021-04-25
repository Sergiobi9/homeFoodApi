package obi.sergi.homefood.Entities.Food;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "FOOD")
public class Food {

    @Id
    private String id;
    private String name;
    private String familyId;
    private String creatorUserId;
    private String dateAdded;
    private ArrayList<String> availableFoodLocationIds;

    public Food(){}

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

    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    public String getCreatorUserId() {
        return creatorUserId;
    }

    public void setCreatorUserId(String creatorUserId) {
        this.creatorUserId = creatorUserId;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public ArrayList<String> getAvailableFoodLocationIds() {
        return availableFoodLocationIds;
    }

    public void setAvailableFoodLocationIds(ArrayList<String> availableFoodLocationIds) {
        this.availableFoodLocationIds = availableFoodLocationIds;
    }
}
