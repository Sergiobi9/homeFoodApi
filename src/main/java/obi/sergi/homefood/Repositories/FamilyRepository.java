package obi.sergi.homefood.Repositories;

import obi.sergi.homefood.Entities.Family;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FamilyRepository extends MongoRepository<Family, String> {

}
