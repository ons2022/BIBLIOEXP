package biblioexp.bibleo.Controller;

import biblioexp.bibleo.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
