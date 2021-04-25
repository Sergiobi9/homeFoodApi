package obi.sergi.homefood.Entities.ItemLocation;

import obi.sergi.homefood.Entities.Item.Item;

public class ItemLocationDetails {

    private String id;
    private String name;
    private double latitude;
    private double longitude;

    public ItemLocationDetails(ItemLocation itemLocation){
        this.id = itemLocation.getId();
        this.name = itemLocation.getName();
        this.latitude = itemLocation.getLatitude();
        this.longitude = itemLocation.getLongitude();
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

    public void setName(String name) {
        this.name = name;
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
}
