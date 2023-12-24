package biblioexp.bibleo.Controller;

import biblioexp.bibleo.Entity.User;
import biblioexp.bibleo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository; // Assuming you have a UserRepository

    // Define your REST endpoints here
    // For example, a simple endpoint to get all users
    @GetMapping
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
}
}
