package obi.sergi.homefood.Repositories.Food;

import obi.sergi.homefood.Entities.Food.Food;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FoodRepository extends MongoRepository<Food, String> {

    Food findFoodById(String foodId);
    List<Food> findFoodsByFamilyId(String familyId);
}
