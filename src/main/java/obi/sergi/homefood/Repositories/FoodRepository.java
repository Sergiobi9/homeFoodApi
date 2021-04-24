package obi.sergi.homefood.Repositories;

import obi.sergi.homefood.Entities.Food;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FoodRepository extends MongoRepository<Food, String> {

}
