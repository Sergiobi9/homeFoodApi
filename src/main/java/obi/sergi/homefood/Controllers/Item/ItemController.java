package obi.sergi.homefood.Controllers.Item;

import obi.sergi.homefood.Entities.Category.Category;
import obi.sergi.homefood.Entities.Category.CategoryDetails;
import obi.sergi.homefood.Entities.Category.CategoryItemRegister;
import obi.sergi.homefood.Entities.Item.Item;
import obi.sergi.homefood.Entities.Item.ItemDetails;
import obi.sergi.homefood.Entities.Item.ItemList;
import obi.sergi.homefood.Entities.ItemLocation.ItemLocation;
import obi.sergi.homefood.Entities.ItemLocation.ItemLocationDetails;
import obi.sergi.homefood.Entities.User.User;
import obi.sergi.homefood.Repositories.Category.CategoryRepository;
import obi.sergi.homefood.Repositories.Item.ItemRepository;
import obi.sergi.homefood.Repositories.ItemLocation.ItemLocationRepository;
import obi.sergi.homefood.Repositories.User.UserRepository;
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
    private ItemLocationRepository itemLocationRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all/list/familyId/{familyId}")
    public ResponseEntity getItemListWithCategories(@PathVariable String familyId) {

        List<ItemList> itemLists = new ArrayList<>();
        List<Category> categories = categoryRepository.findCategoriesByFamilyId(familyId);
        List<String> itemIds = new ArrayList<>();

        /* Get existing item categories */
        for (Category category : categories) {
            ArrayList<CategoryItemRegister> categoryItems = category.getItems();

            ArrayList<ItemDetails> itemDetails = new ArrayList<>();
            for (CategoryItemRegister categoryItemRegister : categoryItems) {
                String itemId = categoryItemRegister.getItemId();

                Item item = itemRepository.findItemById(itemId);
                itemDetails.add(new ItemDetails(item));
                itemIds.add(itemId);
            }

            itemLists.add(new ItemList(category, itemDetails));
        }

        /* Get existing item by family to check if there is any with no category */
        List<Item> allFamilyItem = itemRepository.findItemsByFamilyId(familyId);

        ArrayList<ItemDetails> itemDetails = new ArrayList<>();
        for (Item item : allFamilyItem) {
            String itemId = item.getId();

            if (!itemIds.contains(itemId)) {
                itemDetails.add(new ItemDetails(item));
            }
        }

        /* Add category others if remaining item with no categories */
        if (!itemDetails.isEmpty()) {
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

        if (category != null) {
            ArrayList<CategoryItemRegister> items = category.getItems();
            items.add(new CategoryItemRegister(item));
            category.setItems(items);
            categoryRepository.save(category);
        }

        model.put(Response.INFO, SUCCESS);
        return new ResponseEntity(model, HttpStatus.valueOf(200));
    }

    @GetMapping("/detailed/itemId/{itemId}")
    public ResponseEntity getItemDetailsByItemId(@PathVariable String itemId) {
        Map<Object, Object> model = new HashMap<>();

        Item item = itemRepository.findItemById(itemId);

        List<CategoryDetails> categoryDetails = new ArrayList<>();
        List<Category> categories = categoryRepository.findByItemId(itemId);

        for (Category category : categories) {
            categoryDetails.add(new CategoryDetails(category));
        }

        List<ItemLocationDetails> itemLocationDetails = new ArrayList<>();
        List<String> itemLocationIds = item.getAvailableItemLocationIds();
        for (String itemLocationId : itemLocationIds) {
            ItemLocation itemLocation = itemLocationRepository.findItemLocationById(itemLocationId);
            itemLocationDetails.add(new ItemLocationDetails(itemLocation));
        }

        String creatorUserId = item.getCreatorUserId();
        User user = userRepository.findUserById(creatorUserId);
        String itemRegisteredDate = item.getDateAdded();
        ItemDetails itemDetails = new ItemDetails(item, user, itemRegisteredDate);

        model.put("itemDetails", itemDetails);
        model.put("categoryDetails", categoryDetails);
        model.put("itemLocationDetails", itemLocationDetails);

        return new ResponseEntity(model, HttpStatus.valueOf(200));
    }

    @PutMapping("/update/itemId/{itemId}/availability/{availability}")
    public ResponseEntity updateItemAvailability(@PathVariable String itemId, @PathVariable int availability) {
        Item item = itemRepository.findItemById(itemId);
        item.setAvailability(availability);
        itemRepository.save(item);
        return new ResponseEntity(availability, HttpStatus.valueOf(200));
    }
}
