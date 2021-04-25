package obi.sergi.homefood.Entities.ItemLocation;

public class ItemLocationSimplified {

    private String foodLocationId;
    private String foodLocationName;

    public ItemLocationSimplified(ItemLocation itemLocation) {
        this.foodLocationId = itemLocation.getId();
        this.foodLocationName = itemLocation.getName();
    }

    public String getFoodLocationId() {
        return foodLocationId;
    }

    public void setFoodLocationId(String foodLocationId) {
        this.foodLocationId = foodLocationId;
    }

    public String getFoodLocationName() {
        return foodLocationName;
    }

    public void setFoodLocationName(String foodLocationName) {
        this.foodLocationName = foodLocationName;
    }
}
