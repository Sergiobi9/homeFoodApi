package obi.sergi.homefood.Entities.Food;

import obi.sergi.homefood.Entities.Category.Category;

import java.util.ArrayList;

public class FoodList {

    private String categoryId;
    private String categoryName;
    private ArrayList<FoodItem> foodItems;

    public FoodList(Category category, ArrayList<FoodItem> foodItems){
        this.categoryId = category.getId();
        this.categoryName = category.getName();
        this.foodItems = foodItems;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public ArrayList<FoodItem> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(ArrayList<FoodItem> foodItems) {
        this.foodItems = foodItems;
    }
}
