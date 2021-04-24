package obi.sergi.homefood.Repositories.Role;

import obi.sergi.homefood.Entities.Role.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {

    Role findByRole(String role);
}
