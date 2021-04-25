package obi.sergi.homefood.Entities.Item;

public class ItemDetails {

    private String id;
    private String name;

    public ItemDetails(Item item){
        this.id = item.getId();
        this.name = item.getName();
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
