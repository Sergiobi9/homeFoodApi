package obi.sergi.homefood.Entities.ItemLocation;

public class ItemLocationSimplified {

    private String itemLocationId;
    private String itemLocationName;

    public ItemLocationSimplified(ItemLocation itemLocation) {
        this.itemLocationId = itemLocation.getId();
        this.itemLocationName = itemLocation.getName();
    }

    public String getItemLocationId() {
        return itemLocationId;
    }

    public void setItemLocationId(String itemLocationId) {
        this.itemLocationId = itemLocationId;
    }

    public String getItemLocationName() {
        return itemLocationName;
    }

    public void setItemLocationName(String itemLocationName) {
        this.itemLocationName = itemLocationName;
    }
}
