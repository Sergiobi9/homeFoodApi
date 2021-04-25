package obi.sergi.homefood.Entities.Food;

public class FoodItem {

    private String id;
    private String name;

    public FoodItem(Food food){
        this.id = food.getId();
        this.name = food.getName();
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
}
