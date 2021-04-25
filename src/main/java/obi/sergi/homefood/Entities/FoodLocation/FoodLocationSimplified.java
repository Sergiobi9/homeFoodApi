package obi.sergi.homefood.Entities.FoodLocation;

public class FoodLocationSimplified {

    private String foodLocationId;
    private String foodLocationName;

    public FoodLocationSimplified(FoodLocation foodLocation) {
        this.foodLocationId = foodLocation.getId();
        this.foodLocationName = foodLocation.getName();
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
