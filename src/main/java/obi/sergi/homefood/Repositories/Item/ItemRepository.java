package obi.sergi.homefood.Repositories.Item;

import obi.sergi.homefood.Entities.Item.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ItemRepository extends MongoRepository<Item, String> {

    Item findItemById(String itemId);
    List<Item> findItemsByFamilyId(String familyId);
}
