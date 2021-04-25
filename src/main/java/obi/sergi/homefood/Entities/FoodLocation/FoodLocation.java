package obi.sergi.homefood.Entities.FoodLocation;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "FOOD_LOCATION")
public class FoodLocation {

    private String id;
    private String name;
    private String latitude;
    private String longitude;
    private String street;
    private String familyId;
    private String creatorId;
    private String dateAdded;

    public FoodLocation(){}

    public FoodLocation(FoodLocationRegisterSimplified foodLocationRegisterSimplified){
        this.name = foodLocationRegisterSimplified.getName();
        this.familyId = foodLocationRegisterSimplified.getFamilyId();
        this.creatorId = foodLocationRegisterSimplified.getCreatorId();
        this.dateAdded = foodLocationRegisterSimplified.getDateAdded();
    }


    public FoodLocation(String foodLocationName){
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

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
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
