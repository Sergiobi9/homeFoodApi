package obi.sergi.homefood.Repositories.Category;

import obi.sergi.homefood.Entities.Category.Category;
import obi.sergi.homefood.Entities.Family.Family;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CategoryRepository extends MongoRepository<Category, String> {

    Category findCategoryByName(String name);
    List<Category> findCategoriesByFamilyId(String familyId);
}