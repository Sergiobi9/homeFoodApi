package obi.sergi.homefood.Entities.Category;

import obi.sergi.homefood.Entities.Item.Item;

public class CategoryDetails {

    private String id;
    private String name;

    public CategoryDetails(Category category){
        this.id = category.getId();
        this.name = category.getName();
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
