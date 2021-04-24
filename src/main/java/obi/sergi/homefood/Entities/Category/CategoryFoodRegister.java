package obi.sergi.homefood.Entities.Category;

public class CategoryFoodRegister {

    private String foodId;
    private String dateAdded;

    public CategoryFoodRegister(){}

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
