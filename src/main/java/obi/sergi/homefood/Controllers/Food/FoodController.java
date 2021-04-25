package obi.sergi.homefood.Controllers.Food;

import obi.sergi.homefood.Entities.Category.Category;
import obi.sergi.homefood.Entities.Category.CategoryFoodRegister;
import obi.sergi.homefood.Entities.Family.FamilyRegister;
import obi.sergi.homefood.Entities.Food.Food;
import obi.sergi.homefood.Entities.Food.FoodItem;
import obi.sergi.homefood.Entities.Food.FoodList;
import obi.sergi.homefood.Repositories.Category.CategoryRepository;
import obi.sergi.homefood.Repositories.Food.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private FoodRepository foodRepository;

    @GetMapping("/all/list/familyId/{familyId}")
    public ResponseEntity getFoodListWithCategories(@PathVariable String familyId) {

        List<FoodList> foodLists = new ArrayList<>();
        List<Category> categories = categoryRepository.findCategoriesByFamilyId(familyId);
        List<String> foodIds = new ArrayList<>();

        /* Get existing food categories */
        for (Category category : categories){
            ArrayList<CategoryFoodRegister> categoryFood = category.getFoodItems();

            ArrayList<FoodItem> foodItems = new ArrayList<>();
            for (CategoryFoodRegister categoryFoodRegister : categoryFood){
                String foodId = categoryFoodRegister.getFoodId();

                Food food = foodRepository.findFoodById(foodId);
                foodItems.add(new FoodItem(food));
                foodIds.add(foodId);
            }

            foodLists.add(new FoodList(category, foodItems));
        }

        /* Get existing food by family to check if there is any with no category */
        List<Food> allFamilyFood = foodRepository.findFoodsByFamilyId(familyId);

        ArrayList<FoodItem> foodItems = new ArrayList<>();
        for (Food food : allFamilyFood){
            String foodId = food.getId();

            if (!foodIds.contains(foodId)){
                foodItems.add(new FoodItem(food));
            }
        }

        /* Add category others if remaining food with no categories */
        if (!foodItems.isEmpty()){
            FoodList foodRemainigWithNoCategories = new FoodList(foodItems);
            foodLists.add(foodRemainigWithNoCategories);
        }

        return new ResponseEntity(foodLists, HttpStatus.valueOf(200));
    }
}
