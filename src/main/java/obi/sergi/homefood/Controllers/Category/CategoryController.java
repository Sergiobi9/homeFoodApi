package obi.sergi.homefood.Controllers.Category;

import obi.sergi.homefood.Entities.Category.Category;
import obi.sergi.homefood.Entities.Category.CategoryFoodRegister;
import obi.sergi.homefood.Entities.Role.Role;
import obi.sergi.homefood.Repositories.Category.CategoryRepository;
import obi.sergi.homefood.Utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static obi.sergi.homefood.Utils.Response.CATEGORY_EXISTS;
import static obi.sergi.homefood.Utils.Response.SUCCESS;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping("/register")
    public ResponseEntity registerCategory(@RequestBody Category category) {
        Map<Object, Object> model = new HashMap<>();

        String categoryName = category.getName();

        Category categoryToCheck = categoryRepository.findCategoryByName(categoryName);
        if (categoryToCheck != null){
            model.put(Response.INFO, CATEGORY_EXISTS);
            return new ResponseEntity(model, HttpStatus.valueOf(200));
        }

        ArrayList<CategoryFoodRegister> foodItems = category.getFoodItems();
        if (foodItems == null) category.setFoodItems(new ArrayList<>());

        categoryRepository.save(category);
        model.put(Response.INFO, SUCCESS);
        return new ResponseEntity(model, HttpStatus.valueOf(200));
    }
}
