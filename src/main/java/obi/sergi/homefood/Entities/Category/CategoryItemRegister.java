package obi.sergi.homefood.Entities.Category;

import obi.sergi.homefood.Entities.Item.Item;

public class CategoryItemRegister {

    private String itemId;
    private String dateAdded;

    public CategoryItemRegister(){}

    public CategoryItemRegister(Item item){
        this.itemId = item.getId();
        this.dateAdded = item.getDateAdded();
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }
}
