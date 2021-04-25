package obi.sergi.homefood.Controllers.Item;

import obi.sergi.homefood.Entities.Category.Category;
import obi.sergi.homefood.Entities.Category.CategoryItemRegister;
import obi.sergi.homefood.Entities.Item.Item;
import obi.sergi.homefood.Entities.Item.ItemDetail;
import obi.sergi.homefood.Entities.Item.ItemList;
import obi.sergi.homefood.Repositories.Category.CategoryRepository;
import obi.sergi.homefood.Repositories.Item.ItemRepository;
import obi.sergi.homefood.Utils.Constants;
import obi.sergi.homefood.Utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static obi.sergi.homefood.Utils.Response.SUCCESS;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping("/all/list/familyId/{familyId}")
    public ResponseEntity getItemListWithCategories(@PathVariable String familyId) {

        List<ItemList> itemLists = new ArrayList<>();
        List<Category> categories = categoryRepository.findCategoriesByFamilyId(familyId);
        List<String> itemIds = new ArrayList<>();

        /* Get existing item categories */
        for (Category category : categories){
            ArrayList<CategoryItemRegister> categoryItems = category.getItems();

            ArrayList<ItemDetail> itemDetails = new ArrayList<>();
            for (CategoryItemRegister categoryItemRegister : categoryItems){
                String itemId = categoryItemRegister.getItemId();

                Item item = itemRepository.findItemById(itemId);
                itemDetails.add(new ItemDetail(item));
                itemIds.add(itemId);
            }

            itemLists.add(new ItemList(category, itemDetails));
        }

        /* Get existing item by family to check if there is any with no category */
        List<Item> allFamilyItem = itemRepository.findItemsByFamilyId(familyId);

        ArrayList<ItemDetail> itemDetails = new ArrayList<>();
        for (Item item : allFamilyItem){
            String itemId = item.getId();

            if (!itemIds.contains(itemId)){
                itemDetails.add(new ItemDetail(item));
            }
        }

        /* Add category others if remaining item with no categories */
        if (!itemDetails.isEmpty()){
            ItemList itemRemainingWithNoCategories = new ItemList(itemDetails);
            itemLists.add(itemRemainingWithNoCategories);
        }

        return new ResponseEntity(itemLists, HttpStatus.valueOf(200));
    }

    @PostMapping("/register/categoryId/{categoryId}")
    public ResponseEntity registerItemToCategory(@PathVariable String categoryId, @RequestBody Item item) {
        Map<Object, Object> model = new HashMap<>();

        Category category = categoryRepository.findCategoryById(categoryId);
        item.setAvailability(Constants.ITEM_UNDEFINED_AVAILABILITY);
        itemRepository.save(item);

        if (category != null){
            ArrayList<CategoryItemRegister> items = category.getItems();
            items.add(new CategoryItemRegister(item));
            category.setItems(items);
            categoryRepository.save(category);
        }

        model.put(Response.INFO, SUCCESS);
        return new ResponseEntity(model, HttpStatus.valueOf(200));
    }
}
