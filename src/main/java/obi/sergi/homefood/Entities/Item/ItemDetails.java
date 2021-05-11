package obi.sergi.homefood.Entities.Item;

import obi.sergi.homefood.Entities.User.User;

public class ItemDetails {

    private String id;
    private String name;
    private String creatorFirstName;
    private String creatorLastName;
    private String registeredDate;
    private double price;
    private int availability;

    public ItemDetails(Item item, User user, String registeredDate){
        this.id = item.getId();
        this.name = item.getName();
        this.creatorFirstName = user.getFirstName();
        this.creatorLastName = user.getLastName();
        this.registeredDate = registeredDate;
        this.price = item.getPrice();
        this.availability = item.getAvailability();
    }

    public ItemDetails(Item item){
        this.id = item.getId();
        this.name = item.getName();
        this.availability = item.getAvailability();
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

    public String getCreatorFirstName() {
        return creatorFirstName;
    }

    public void setCreatorFirstName(String creatorFirstName) {
        this.creatorFirstName = creatorFirstName;
    }

    public String getCreatorLastName() {
        return creatorLastName;
    }

    public void setCreatorLastName(String creatorLastName) {
        this.creatorLastName = creatorLastName;
    }

    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }

    public int getAvailability() {
        return availability;
    }

    public void setAvailability(int availability) {
        this.availability = availability;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
