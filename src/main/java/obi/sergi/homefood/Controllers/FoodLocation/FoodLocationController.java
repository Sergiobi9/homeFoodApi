package obi.sergi.homefood.Controllers.FoodLocation;

import obi.sergi.homefood.Entities.Category.Category;
import obi.sergi.homefood.Entities.Category.CategoryFoodRegister;
import obi.sergi.homefood.Entities.Family.FamilyMemberUserRequest;
import obi.sergi.homefood.Entities.Food.Food;
import obi.sergi.homefood.Entities.Food.FoodItem;
import obi.sergi.homefood.Entities.Food.FoodList;
import obi.sergi.homefood.Entities.FoodLocation.FoodLocation;
import obi.sergi.homefood.Entities.FoodLocation.FoodLocationRegisterSimplified;
import obi.sergi.homefood.Entities.FoodLocation.FoodLocationSimplified;
import obi.sergi.homefood.Repositories.FoodLocation.FoodLocationRepository;
import obi.sergi.homefood.Utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static obi.sergi.homefood.Utils.Response.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/food/location")
public class FoodLocationController {

    @Autowired
    private FoodLocationRepository foodLocationRepository;

    @GetMapping("/all/familyId/{familyId}")
    public ResponseEntity getFamilyFoodLocations(@PathVariable String familyId) {
        List<FoodLocation> foodLocations = foodLocationRepository.findFoodLocationsByFamilyId(familyId);
        List<FoodLocationSimplified> foodLocationsToReturn = new ArrayList<>();

        for (FoodLocation foodLocation : foodLocations){
            foodLocationsToReturn.add(new FoodLocationSimplified(foodLocation));
        }

        return new ResponseEntity(foodLocationsToReturn, HttpStatus.valueOf(200));
    }

    @PostMapping("/register/name")
    public ResponseEntity registerFoodLocationName(@RequestBody FoodLocationRegisterSimplified foodLocationRegisterSimplified) {
        String foodLocationName = foodLocationRegisterSimplified.getName();
        FoodLocation foodLocation = foodLocationRepository.findFoodLocationByName(foodLocationName);

        if (foodLocation == null){
            foodLocationRepository.save(new FoodLocation(foodLocationRegisterSimplified));
            return new ResponseEntity(foodLocationRegisterSimplified, HttpStatus.valueOf(200));
        } else {
            return new ResponseEntity(null, HttpStatus.valueOf(200));
        }
    }

    @PostMapping("/register")
    public ResponseEntity registerFoodLocation(@RequestBody FoodLocation foodLocation) {
        Map<Object, Object> model = new HashMap<>();

        String foodLocationName = foodLocation.getName();
        FoodLocation foodLocationToCheck = foodLocationRepository.findFoodLocationByName(foodLocationName);

        if (foodLocationToCheck != null){
            model.put(Response.INFO, FOOD_LOCATION_EXISTS);
            return new ResponseEntity(model, HttpStatus.valueOf(200));
        }

        foodLocationRepository.save(foodLocation);

        model.put(Response.INFO, SUCCESS);
        return new ResponseEntity(model, HttpStatus.valueOf(200));
    }


}
