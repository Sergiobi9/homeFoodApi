package obi.sergi.homefood.Entities.Item;

import obi.sergi.homefood.Entities.Category.Category;

import java.util.ArrayList;

public class ItemList {

    private String categoryId;
    private String categoryName;
    private ArrayList<ItemDetails> itemDetails;

    public ItemList(Category category, ArrayList<ItemDetails> itemDetails){
        this.categoryId = category.getId();
        this.categoryName = category.getName();
        this.itemDetails = itemDetails;
    }

    public ItemList(ArrayList<ItemDetails> itemDetails){
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

    public ArrayList<ItemDetails> getItemDetails() {
        return itemDetails;
    }

    public void setItemDetails(ArrayList<ItemDetails> itemDetails) {
        this.itemDetails = itemDetails;
    }
}
