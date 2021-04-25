package obi.sergi.homefood.Repositories.ItemLocation;

import obi.sergi.homefood.Entities.ItemLocation.ItemLocation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ItemLocationRepository extends MongoRepository<ItemLocation, String> {

    List<ItemLocation> findItemLocationsByFamilyId(String familyId);
    ItemLocation findItemLocationByName(String foodLocationName);

}
