package obi.sergi.homefood.Repositories.Food;

import obi.sergi.homefood.Entities.Food.Food;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FoodRepository extends MongoRepository<Food, String> {

    Food findFoodById(String foodId);
}
