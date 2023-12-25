package biblioexp.bibleo.Service;

import biblioexp.bibleo.Entity.User;
import jakarta.validation.Valid;


import java.util.List;

public interface UserService {
    public void saveUser(User user);
    public List<Object> isUserPresent(@Valid User user);
}
