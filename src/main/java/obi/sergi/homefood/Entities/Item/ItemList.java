package obi.sergi.homefood.Entities.Item;

import obi.sergi.homefood.Entities.Category.Category;

import java.util.ArrayList;

public class ItemList {

    private String categoryId;
    private String categoryName;
    private ArrayList<ItemDetail> itemDetails;

    public ItemList(Category category, ArrayList<ItemDetail> itemDetails){
        this.categoryId = category.getId();
        this.categoryName = category.getName();
        this.itemDetails = itemDetails;
    }

    public ItemList(ArrayList<ItemDetail> itemDetails){
        this.categoryId = "";
        this.categoryName = "";
        this.itemDetails = itemDetails;
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

    public ArrayList<ItemDetail> getItemDetails() {
        return itemDetails;
    }

    public void setItemDetails(ArrayList<ItemDetail> itemDetails) {
        this.itemDetails = itemDetails;
    }
}
