package obi.sergi.homefood.Repositories.Family;

import obi.sergi.homefood.Entities.Family.Family;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FamilyRepository extends MongoRepository<Family, String> {

}
