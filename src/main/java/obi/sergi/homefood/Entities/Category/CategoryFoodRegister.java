package obi.sergi.homefood.Entities.Category;

import obi.sergi.homefood.Entities.Food.Food;

public class CategoryFoodRegister {

    private String foodId;
    private String dateAdded;

    public CategoryFoodRegister(){}

    public CategoryFoodRegister(Food food){
        this.foodId = food.getId();
        this.dateAdded = food.getDateAdded();
    }

    public String getFoodId() {
        return foodId;
    }

    public void setFoodId(String foodId) {
        this.foodId = foodId;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }
}
