package obi.sergi.homefood.Repositories.Category;

import obi.sergi.homefood.Entities.Category.Category;
import obi.sergi.homefood.Entities.Family.Family;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CategoryRepository extends MongoRepository<Category, String> {

    Category findCategoryByName(String name);
    Category findCategoryById(String categoryId);
    List<Category> findCategoriesByFamilyId(String familyId);
    @org.springframework.data.mongodb.repository.Query(value = "{ 'items': { $elemMatch: { 'itemId' : ?0 } }}")
    List<Category> findByItemId(String familyId);
}