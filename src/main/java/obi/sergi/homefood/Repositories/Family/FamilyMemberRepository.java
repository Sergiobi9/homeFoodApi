package obi.sergi.homefood.Repositories.Family;

import obi.sergi.homefood.Entities.Food.Food;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FamilyMemberRepository extends MongoRepository<Food, String> {

}