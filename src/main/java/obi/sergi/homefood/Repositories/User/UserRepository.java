package obi.sergi.homefood.Repositories.User;

import obi.sergi.homefood.Entities.Role.Role;
import obi.sergi.homefood.Entities.User.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    User findUserById(String userId);
    User findUserByEmail(String email);

}