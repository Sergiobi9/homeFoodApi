package obi.sergi.homefood.Entities.Item;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document(collection = "ITEM")
public class Item {

    @Id
    private String id;
    private String name;
    private String familyId;
    private String creatorUserId;
    private String dateAdded;
    private int availability;
    private double price;
    private ArrayList<String> availableItemLocationIds;

    public Item(){}

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

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public ArrayList<String> getAvailableItemLocationIds() {
        return availableItemLocationIds;
    }

    public void setAvailableItemLocationIds(ArrayList<String> availableItemLocationIds) {
        this.availableItemLocationIds = availableItemLocationIds;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
