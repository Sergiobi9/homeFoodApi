package obi.sergi.homefood.Entities.ItemLocation;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ITEM_LOCATION")
public class ItemLocation {

    private String id;
    private String name;
    private double latitude;
    private double longitude;
    private String street;
    private String familyId;
    private String creatorId;
    private String dateAdded;

    public ItemLocation(){}

    public ItemLocation(ItemLocationRegisterSimplified itemLocationRegisterSimplified){
        this.name = itemLocationRegisterSimplified.getName();
        this.familyId = itemLocationRegisterSimplified.getFamilyId();
        this.creatorId = itemLocationRegisterSimplified.getCreatorId();
        this.dateAdded = itemLocationRegisterSimplified.getDateAdded();
    }


    public ItemLocation(String foodLocationName){
        this.name = foodLocationName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
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

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }
}
