package obi.sergi.homefood.Repositories.FoodLocation;

import obi.sergi.homefood.Entities.FoodLocation.FoodLocation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FoodLocationRepository extends MongoRepository<FoodLocation, String> {

    List<FoodLocation> findFoodLocationsByFamilyId(String familyId);
    FoodLocation findFoodLocationByName(String foodLocationName);

}
