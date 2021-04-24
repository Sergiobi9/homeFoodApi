package obi.sergi.homefood.Repositories.Family;

import obi.sergi.homefood.Entities.Family.FamilyMember;
import obi.sergi.homefood.Entities.Food.Food;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FamilyMemberRepository extends MongoRepository<FamilyMember, String> {
    @org.springframework.data.mongodb.repository.Query(value = "{ 'familyMembers': { $elemMatch: { 'userId' : ?0 } }}")
    FamilyMember findByUserId(String userId);
}