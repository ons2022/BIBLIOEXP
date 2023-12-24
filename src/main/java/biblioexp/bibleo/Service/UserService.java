package biblioexp.bibleo.Service;

import  biblioexp.bibleo.dto.UserDto;
import  biblioexp.bibleo.Entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
